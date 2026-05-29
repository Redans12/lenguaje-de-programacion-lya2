package com.u2proyecto;

import java.util.HashMap;
import org.antlr.v4.runtime.misc.Interval;
import com.u2proyecto.EBDAParser.*;

public class EBDAToCVisitor extends EBDABaseVisitor<String> {

    private int indentLevel = 0;
    private final HashMap<String, String> tipos = new HashMap<>();

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    @Override
    public String visitStart(StartContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("// Código generado desde EBDA\n");
        sb.append("#include <stdio.h>\n");
        sb.append("#include <string.h>\n\n");
        sb.append("int main() {\n");
        indentLevel++;
        for (StatementContext stmt : ctx.statement()) {
            sb.append(visit(stmt));
        }
        sb.append(indent()).append("return 0;\n");
        indentLevel--;
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public String visitStatement(StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        String tipo = ctx.type().getText();
        String id = ctx.IDENTIFIER().getText();
        tipos.put(id, tipo);

        if (tipo.equals("chat")) {
            // manejar concatenación directamente desde el árbol
            if (ctx.expression().getChildCount() == 3
                    && ctx.expression().getChild(1).getText().equals("+")) {
                String izq = visit(ctx.expression().expression(0));
                String der = visit(ctx.expression().expression(1));
                return indent() + "char " + id + "[256] = " + izq + ";\n"
                        + indent() + "strcat(" + id + ", " + der + ");\n";
            }
            String valor = visit(ctx.expression());
            if (valor.startsWith("\"")) {
                return indent() + "char " + id + "[256] = " + valor + ";\n";
            }
            return indent() + "char " + id + "[256];\n"
                    + indent() + "strcpy(" + id + ", " + valor + ");\n";
        }

        String valor = visit(ctx.expression());
        return indent() + mapTipo(tipo) + " " + id + " = " + valor + ";\n";
    }

    @Override
    public String visitAssignment(AssignmentContext ctx) {
        String texto = ctx.getText();
        if (texto.startsWith("buffear")) {
            String id = ctx.IDENTIFIER().getText();
            return indent() + id + "++;\n";
        }
        if (texto.startsWith("nerfear")) {
            String id = ctx.IDENTIFIER().getText();
            return indent() + id + "--;\n";
        }
        String id = ctx.IDENTIFIER().getText();
        String valor = visit(ctx.expression());
        if ("chat".equals(tipos.get(id))) {
            return indent() + "strcpy(" + id + ", " + valor + ");\n";
        }
        return indent() + id + " = " + valor + ";\n";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        String expr = visit(ctx.expression());
        // string literal
        if (expr.startsWith("\"")) {
            return indent() + "printf(\"%s\\n\", " + expr + ");\n";
        }
        // variable de tipo chat
        if (ctx.expression().IDENTIFIER() != null) {
            String id = ctx.expression().IDENTIFIER().getText();
            if ("chat".equals(tipos.get(id))) {
                return indent() + "printf(\"%s\\n\", " + id + ");\n";
            }
        }
        return indent() + "printf(\"%d\\n\", " + expr + ");\n";
    }

    @Override
    public String visitRushStmt(RushStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        String condicion = visit(ctx.expression());
        sb.append(indent()).append("if (").append(condicion).append(") {\n");
        indentLevel++;
        for (StatementContext s : ctx.ifBlock)
            sb.append(visit(s));
        indentLevel--;
        sb.append(indent()).append("}");
        if (!ctx.afkBlock.isEmpty()) {
            sb.append(" else {\n");
            indentLevel++;
            for (StatementContext s : ctx.afkBlock)
                sb.append(visit(s));
            indentLevel--;
            sb.append(indent()).append("}");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String visitRespawnStmt(RespawnStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        String condicion = visit(ctx.expression());
        sb.append(indent()).append("while (").append(condicion).append(") {\n");
        indentLevel++;
        for (StatementContext s : ctx.statement())
            sb.append(visit(s));
        indentLevel--;
        sb.append(indent()).append("}\n");
        return sb.toString();
    }

    @Override
    public String visitWinStmt(WinStmtContext ctx) {
        String valor = visit(ctx.expression());
        return indent() + "return " + valor + ";\n";
    }

    @Override
    public String visitExpression(ExpressionContext ctx) {
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            return "!" + visit(ctx.expression(0));
        }
        if (ctx.getChildCount() == 3
                && ctx.getChild(0).getText().equals("(")
                && ctx.getChild(2).getText().equals(")")) {
            return "(" + visit(ctx.expression(0)) + ")";
        }
        if (ctx.getChildCount() == 3 && ctx.expression().size() == 2) {
            String izq = visit(ctx.expression(0));
            String der = visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();
            if (op.equals("="))
                op = "==";
            // concatenación de strings
            if (op.equals("+") && (izq.startsWith("\"") || "chat".equals(tipos.get(izq)))) {
                return "strcat(" + izq + ", " + der + ")";
            }
            return izq + " " + op + " " + der;
        }
        if (ctx.NUMBER() != null)
            return ctx.NUMBER().getText();
        if (ctx.STRING() != null)
            return ctx.STRING().getText();
        if (ctx.getText().equals("online"))
            return "1";
        if (ctx.getText().equals("offline"))
            return "0";
        if (ctx.getText().equals("npc"))
            return "NULL";
        if (ctx.IDENTIFIER() != null)
            return ctx.IDENTIFIER().getText();
        return "";
    }

    @Override
    public String visitType(TypeContext ctx) {
        return mapTipo(ctx.getText());
    }

    private String mapTipo(String tipo) {
        switch (tipo) {
            case "healthpoints":
                return "int";
            case "chat":
                return "char*";
            case "online":
                return "int";
            default:
                return "void";
        }
    }
}