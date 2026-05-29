package com.u2proyecto;

import java.util.HashMap;
import org.antlr.v4.runtime.misc.Interval;
import com.u2proyecto.EBDAParser.*;

public class EBDAToCSharpVisitor extends EBDABaseVisitor<String> {

    private int indentLevel = 0;
    private final HashMap<String, String> tipos = new HashMap<>();

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    @Override
    public String visitStart(StartContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("// Código generado desde EBDA\n");
        sb.append("using System;\n\n");
        sb.append("class Program {\n");
        sb.append("    static void Main(string[] args) {\n");
        indentLevel = 2;
        for (StatementContext stmt : ctx.statement()) {
            sb.append(visit(stmt));
        }
        indentLevel = 1;
        sb.append("    }\n");
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
        String valor = visit(ctx.expression());
        tipos.put(id, tipo);
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
        return indent() + id + " = " + valor + ";\n";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        String valor = visit(ctx.expression());
        return indent() + "Console.WriteLine(" + valor + ");\n";
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
        return indent() + "return;\n";
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
            return izq + " " + op + " " + der;
        }
        if (ctx.NUMBER() != null)
            return ctx.NUMBER().getText();
        if (ctx.STRING() != null)
            return ctx.STRING().getText();
        if (ctx.getText().equals("online"))
            return "true";
        if (ctx.getText().equals("offline"))
            return "false";
        if (ctx.getText().equals("npc"))
            return "null";
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
                return "string";
            case "online":
                return "bool";
            default:
                return "var";
        }
    }
}