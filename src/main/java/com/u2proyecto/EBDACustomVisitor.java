package com.u2proyecto;

import java.util.HashMap;
import com.u2proyecto.EBDAParser.AssignmentContext;
import com.u2proyecto.EBDAParser.DeclarationContext;
import com.u2proyecto.EBDAParser.ExpressionContext;
import com.u2proyecto.EBDAParser.PrintStmtContext;
import com.u2proyecto.EBDAParser.RespawnStmtContext;
import com.u2proyecto.EBDAParser.RushStmtContext;
import com.u2proyecto.EBDAParser.StartContext;
import com.u2proyecto.EBDAParser.StatementContext;
import com.u2proyecto.EBDAParser.TypeContext;
import com.u2proyecto.EBDAParser.WinStmtContext;

public class EBDACustomVisitor extends EBDABaseVisitor<Object> {

    private final HashMap<String, Object> tabla_simbolos = new HashMap<>();
    private final HashMap<String, String> tabla_tipos = new HashMap<>();

    @Override
    public Object visitStart(StartContext ctx) {
        for (EBDAParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return null;
    }

    @Override
    public Object visitStatement(StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public Object visitDeclaration(DeclarationContext ctx) {
        String tipo = ctx.type().getText();
        String id = ctx.IDENTIFIER().getText();
        Object valor = visit(ctx.expression());
        if (tabla_simbolos.containsKey(id)) {
            System.out.println("[Error Semántico] Variable '" + id + "' ya fue declarada.");
            return null;
        }
        tabla_tipos.put(id, tipo);
        tabla_simbolos.put(id, valor);
        System.out.println("Declaración: " + tipo + " " + id + " -> " + valor);
        return valor;
    }

    @Override
    public Object visitAssignment(AssignmentContext ctx) {
        if (ctx.getText().startsWith("buffear")) {
            String id = ctx.IDENTIFIER().getText();
            if (!tabla_simbolos.containsKey(id)) {
                System.out.println("[Error Semántico] Variable '" + id + "' no declarada.");
                return null;
            }
            int valor = (int) tabla_simbolos.get(id) + 1;
            tabla_simbolos.put(id, valor);
            System.out.println("buffear " + id + " -> " + valor);
            return valor;
        }
        if (ctx.getText().startsWith("nerfear")) {
            String id = ctx.IDENTIFIER().getText();
            if (!tabla_simbolos.containsKey(id)) {
                System.out.println("[Error Semántico] Variable '" + id + "' no declarada.");
                return null;
            }
            int valor = (int) tabla_simbolos.get(id) - 1;
            tabla_simbolos.put(id, valor);
            System.out.println("nerfear " + id + " -> " + valor);
            return valor;
        }
        String id = ctx.IDENTIFIER().getText();
        if (!tabla_simbolos.containsKey(id)) {
            System.out.println("[Error Semántico] Variable '" + id + "' no declarada. Use 'plant' para declarar.");
            return null;
        }
        Object valor = visit(ctx.expression());
        tabla_simbolos.put(id, valor);
        System.out.println("Asignación: " + id + " -> " + valor);
        return valor;
    }

    @Override
    public Object visitExpression(ExpressionContext ctx) {
        if (ctx.NUMBER() != null) {
            return Integer.parseInt(ctx.NUMBER().getText());
        }
        if (ctx.STRING() != null) {
            String texto = ctx.STRING().getText();
            return texto.substring(1, texto.length() - 1);
        }
        if (ctx.getText().equals("online")) {
            return true;
        }
        if (ctx.getText().equals("offline")) {
            return false;
        }
        if (ctx.getText().equals("npc")) {
            return null;
        }
        if (ctx.IDENTIFIER() != null) {
            String id = ctx.IDENTIFIER().getText();
            if (!tabla_simbolos.containsKey(id)) {
                System.out.println("[Error Semántico] Variable '" + id + "' usada sin declarar.");
                return 0;
            }
            return tabla_simbolos.get(id);
        }
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            Object val = visit(ctx.expression(0));
            if (val instanceof Boolean) return !(Boolean) val;
            return false;
        }
        if (ctx.getChildCount() == 3 && ctx.getChild(0).getText().equals("(")) {
            return visit(ctx.expression(0));
        }
        if (ctx.getChildCount() == 3) {
            Object izq = visit(ctx.expression(0));
            Object der = visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();
            if (izq instanceof Integer && der instanceof Integer) {
                int a = (int) izq;
                int b = (int) der;
                switch (op) {
                    case "+": return a + b;
                    case "-": return a - b;
                    case "*": return a * b;
                    case "/":
                        if (b == 0) {
                            System.out.println("[Error Semántico] División por cero.");
                            return 0;
                        }
                        return a / b;
                    case "=": return a == b;
                    case "<": return a < b;
                    case ">": return a > b;
                }
            }
            if (izq instanceof String && der instanceof String && op.equals("+")) {
                return (String) izq + (String) der;
            }
        }
        return 0;
    }

    @Override
    public Object visitPrintStmt(PrintStmtContext ctx) {
        Object valor = visit(ctx.expression());
        System.out.println("ñ -> " + valor);
        return valor;
    }

    @Override
    public Object visitRushStmt(RushStmtContext ctx) {
        Object condicion = visit(ctx.expression());
        boolean resultado = false;
        if (condicion instanceof Boolean) {
            resultado = (Boolean) condicion;
        } else if (condicion instanceof Integer) {
            resultado = (Integer) condicion != 0;
        }
        if (resultado) {
            for (EBDAParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }
        }
        return null;
    }

    @Override
    public Object visitRespawnStmt(RespawnStmtContext ctx) {
        int maxIteraciones = 1000;
        int contador = 0;
        while (true) {
            Object condicion = visit(ctx.expression());
            boolean resultado = false;
            if (condicion instanceof Boolean) resultado = (Boolean) condicion;
            else if (condicion instanceof Integer) resultado = (Integer) condicion != 0;
            if (!resultado) break;
            for (EBDAParser.StatementContext stmt : ctx.statement()) {
                visit(stmt);
            }
            contador++;
            if (contador >= maxIteraciones) {
                System.out.println("[Error Semántico] Loop infinito detectado, se detiene en " + maxIteraciones + " iteraciones.");
                break;
            }
        }
        return null;
    }

    @Override
    public Object visitWinStmt(WinStmtContext ctx) {
        Object valor = visit(ctx.expression());
        System.out.println("win -> " + valor);
        return valor;
    }

    @Override
    public Object visitType(TypeContext ctx) {
        return ctx.getText();
    }
}