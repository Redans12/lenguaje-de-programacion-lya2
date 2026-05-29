package com.u2proyecto;

import java.util.HashMap;
import java.util.List;
import org.antlr.v4.runtime.misc.Interval;
import com.u2proyecto.EBDAParser.*;

public class EBDACustomVisitor extends EBDABaseVisitor<Object> {

    // =========================================================
    // Fase 3: Clase Símbolo
    // =========================================================
    class Simbolo {
        String tipo;
        Object valor;

        Simbolo(String tipo, Object valor) {
            this.tipo = tipo;
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Simbolo{tipo='" + tipo + "', valor=" + valor + "}";
        }
    }

    private final HashMap<String, Simbolo> tablaSimbolos = new HashMap<>();

    private String getOriginalText(org.antlr.v4.runtime.ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        return ctx.start.getInputStream().getText(interval);
    }

    // =========================================================
    // visitStart
    // =========================================================
    @Override
    public Object visitStart(StartContext ctx) {
        System.out.println("============================================");
        System.out.println("   Iniciando interpretación EBDA");
        System.out.println("============================================");
        for (StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        System.out.println("\n============================================");
        System.out.println("   Interpretación finalizada");
        System.out.println("   Tabla de símbolos final:");
        tablaSimbolos.forEach((k, v) -> System.out.println("      " + k + " : " + v));
        System.out.println("============================================");
        return null;
    }

    @Override
    public Object visitDeclaration(DeclarationContext ctx) {
        String instruccion = getOriginalText(ctx);
        String tipoStr = ctx.type().getText();
        String id = ctx.IDENTIFIER().getText();

        System.out.println("\n[Instrucción - Línea " + ctx.start.getLine() + "]: " + instruccion);

        Object valor = visit(ctx.expression());

        if (tablaSimbolos.containsKey(id)) {
            Simbolo sim = tablaSimbolos.get(id);
            // si el tipo es el mismo, actualiza el valor sin error
            if (sim.tipo.equals(tipoStr)) {
                if (!validarTipo(tipoStr, valor)) {
                    System.err.println("   [Error Semántico] Tipo incompatible en reasignación de '" + id + "'.");
                    return null;
                }
                sim.valor = valor;
                System.out.println("   -> '" + id + "' reasignado a: " + formatValor(valor));
                return valor;
            } else {
                System.err.println("   [Error Semántico] Variable '" + id + "' ya fue declarada con tipo diferente.");
                return null;
            }
        }

        if (!validarTipo(tipoStr, valor)) {
            System.err.println("   [Error Semántico] Tipo incompatible: se esperaba '"
                    + tipoStr + "' pero se obtuvo " + tipoDe(valor)
                    + " en la declaración de '" + id + "'.");
            return null;
        }

        tablaSimbolos.put(id, new Simbolo(tipoStr, valor));
        System.out.println("   -> Declarada '" + id + "' (" + tipoStr + ") = " + formatValor(valor));
        return valor;
    }

    // =========================================================
    // visitAssignment
    // Regla 1: Variable debe estar declarada
    // Regla 5: Tipo compatible en asignación
    // Regla 7: buffear/nerfear solo sobre healthpoints
    // =========================================================
    @Override
    public Object visitAssignment(AssignmentContext ctx) {
        String instruccion = getOriginalText(ctx);
        System.out.println("\n[Instrucción - Línea " + ctx.start.getLine() + "]: " + instruccion);

        if (ctx.getText().startsWith("buffear")) {
            String id = ctx.IDENTIFIER().getText();
            if (!tablaSimbolos.containsKey(id)) {
                System.err.println("   [Error Semántico] Variable '" + id + "' no declarada.");
                return null;
            }
            Simbolo sim = tablaSimbolos.get(id);
            if (!sim.tipo.equals("healthpoints")) {
                System.err.println("   [Error Semántico] 'buffear' solo aplica a tipo 'healthpoints'.");
                return null;
            }
            sim.valor = (int) sim.valor + 1;
            System.out.println("   -> '" + id + "' incrementado a: " + sim.valor);
            return sim.valor;
        }

        if (ctx.getText().startsWith("nerfear")) {
            String id = ctx.IDENTIFIER().getText();
            if (!tablaSimbolos.containsKey(id)) {
                System.err.println("   [Error Semántico] Variable '" + id + "' no declarada.");
                return null;
            }
            Simbolo sim = tablaSimbolos.get(id);
            if (!sim.tipo.equals("healthpoints")) {
                System.err.println("   [Error Semántico] 'nerfear' solo aplica a tipo 'healthpoints'.");
                return null;
            }
            sim.valor = (int) sim.valor - 1;
            System.out.println("   -> '" + id + "' decrementado a: " + sim.valor);
            return sim.valor;
        }

        // asignación directa
        String id = ctx.IDENTIFIER().getText();
        if (!tablaSimbolos.containsKey(id)) {
            System.err.println("   [Error Semántico] Variable '" + id + "' no fue declarada.");
            return null;
        }

        Object nuevoValor = visit(ctx.expression());
        Simbolo sim = tablaSimbolos.get(id);

        if (!validarTipo(sim.tipo, nuevoValor)) {
            System.err.println("   [Error Semántico] Tipo incompatible en asignación: '"
                    + id + "' es '" + sim.tipo + "' pero se asignó " + tipoDe(nuevoValor) + ".");
            return null;
        }

        sim.valor = nuevoValor;
        System.out.println("   -> '" + id + "' actualizado a: " + formatValor(nuevoValor));
        return nuevoValor;
    }

    // =========================================================
    // visitExpression
    // Regla 1: Variables deben estar declaradas
    // Regla 3: Tipos compatibles en operaciones
    // Regla 6: División entre cero no válida
    // =========================================================
    @Override
    public Object visitExpression(ExpressionContext ctx) {

        // Negación lógica: '!' expression
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            Object val = visit(ctx.expression(0));
            if (!(val instanceof Boolean)) {
                System.err.println("   [Error Semántico] '!' solo aplica a valores booleanos.");
                return false;
            }
            return !(Boolean) val;
        }

        // Agrupación: '(' expression ')'
        if (ctx.getChildCount() == 3
                && ctx.getChild(0).getText().equals("(")
                && ctx.getChild(2).getText().equals(")")) {
            return visit(ctx.expression(0));
        }

        // Operación binaria: expression OP expression
        if (ctx.getChildCount() == 3 && ctx.expression().size() == 2) {
            Object izq = visit(ctx.expression(0));
            Object der = visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();

            if (izq instanceof Integer && der instanceof Integer) {
                int a = (int) izq;
                int b = (int) der;
                switch (op) {
                    case "+":
                        return a + b;
                    case "-":
                        return a - b;
                    case "*":
                        return a * b;
                    case "/":
                        if (b == 0) {
                            System.err.println("   [Error Semántico] División entre cero no permitida.");
                            return 0;
                        }
                        return a / b;
                    case "=":
                        return a == b;
                    case "<":
                        return a < b;
                    case ">":
                        return a > b;
                    default:
                        System.err.println("   [Error Semántico] Operador '" + op + "' no reconocido.");
                        return 0;
                }
            }

            // Regla 3: concatenación de strings con '+'
            if (izq instanceof String && der instanceof String && op.equals("+")) {
                return (String) izq + (String) der;
            }

            // Regla 3: tipos incompatibles
            System.err.println("   [Error Semántico] Tipos incompatibles en operación '"
                    + op + "': " + tipoDe(izq) + " y " + tipoDe(der) + ".");
            return 0;
        }

        // Literales
        if (ctx.NUMBER() != null)
            return Integer.parseInt(ctx.NUMBER().getText());
        if (ctx.STRING() != null)
            return ctx.STRING().getText().replace("\"", "");
        if (ctx.getText().equals("online"))
            return true;
        if (ctx.getText().equals("offline"))
            return false;
        if (ctx.getText().equals("npc"))
            return null;

        // Variable
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (!tablaSimbolos.containsKey(id)) {
                System.err.println("   [Error Semántico] Variable '" + id + "' no fue declarada.");
                return 0;
            }
            return tablaSimbolos.get(id).valor;
        }

        System.err.println("   [Error Semántico] Expresión no reconocida: " + ctx.getText());
        return 0;
    }

    // =========================================================
    // visitPrintStmt
    // =========================================================
    @Override
    public Object visitPrintStmt(PrintStmtContext ctx) {
        System.out.println("\n[Instrucción - Línea " + ctx.start.getLine() + "]: " + getOriginalText(ctx));
        Object valor = visit(ctx.expression());
        System.out.println("   -> SALIDA ñ: " + formatValor(valor));
        return null;
    }

    @Override
    public Object visitRushStmt(RushStmtContext ctx) {
        System.out.println("\n[Instrucción rush - Línea " + ctx.start.getLine() + "]: " + getOriginalText(ctx));

        Object condicion = visit(ctx.expression());

        if (!(condicion instanceof Boolean)) {
            System.err.println("   [Error Semántico] La condición del 'rush' debe ser booleana (online/offline).");
            return null;
        }

        boolean resultado = (Boolean) condicion;
        boolean tieneAfk = !ctx.afkBlock.isEmpty();

        if (resultado) {
            System.out.println("   -> Condición VERDADERA, ejecutando bloque rush.");
            for (StatementContext s : ctx.ifBlock)
                visit(s);
        } else if (tieneAfk) {
            System.out.println("   -> Condición FALSA, ejecutando bloque afk.");
            for (StatementContext s : ctx.afkBlock)
                visit(s);
        } else {
            System.out.println("   -> Condición FALSA, sin rama afk.");
        }

        return null;
    }

    // =========================================================
    // visitRespawnStmt (while)
    // Soporta anidamiento completo
    // Regla 4: condición debe ser booleana
    // =========================================================
    @Override
    public Object visitRespawnStmt(RespawnStmtContext ctx) {
        System.out.println("\n[Instrucción respawn - Línea " + ctx.start.getLine() + "]: " + getOriginalText(ctx));

        final int LIMITE = 1000;
        int iteraciones = 0;

        while (true) {
            Object cond = visit(ctx.expression());

            if (!(cond instanceof Boolean)) {
                System.err.println("   [Error Semántico] La condición del 'respawn' debe ser booleana.");
                break;
            }

            if (!(Boolean) cond)
                break;

            if (iteraciones >= LIMITE) {
                System.err.println("   [Advertencia] Límite de " + LIMITE + " iteraciones alcanzado en 'respawn'.");
                break;
            }

            System.out.println("   -> Iteración " + (iteraciones + 1));
            for (StatementContext s : ctx.statement())
                visit(s);
            iteraciones++;
        }

        System.out.println("   -> respawn finalizado tras " + iteraciones + " iteración(es).");
        return null;
    }

    // =========================================================
    // visitWinStmt
    // =========================================================
    @Override
    public Object visitWinStmt(WinStmtContext ctx) {
        System.out.println("\n[Instrucción - Línea " + ctx.start.getLine() + "]: " + getOriginalText(ctx));
        Object valor = visit(ctx.expression());
        System.out.println("   -> win: " + formatValor(valor));
        return valor;
    }

    // =========================================================
    // Helpers
    // =========================================================
    private boolean validarTipo(String tipo, Object valor) {
        if (valor == null)
            return true;
        switch (tipo) {
            case "healthpoints":
                return valor instanceof Integer;
            case "chat":
                return valor instanceof String;
            case "online":
                return valor instanceof Boolean;
            default:
                return false;
        }
    }

    private String tipoDe(Object valor) {
        if (valor == null)
            return "npc";
        if (valor instanceof Integer)
            return "healthpoints";
        if (valor instanceof String)
            return "chat";
        if (valor instanceof Boolean)
            return "online";
        return "desconocido";
    }

    private String formatValor(Object valor) {
        if (valor == null)
            return "npc";
        if (valor instanceof Boolean)
            return (Boolean) valor ? "online" : "offline";
        return valor.toString();
    }

}