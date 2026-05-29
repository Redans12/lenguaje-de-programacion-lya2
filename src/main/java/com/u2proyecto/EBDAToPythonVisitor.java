package com.u2proyecto;

import org.antlr.v4.runtime.misc.Interval;
import com.u2proyecto.EBDAParser.*;

public class EBDAToPythonVisitor extends EBDABaseVisitor<String> {

    private int indentLevel = 0;

    private String indent() {
        return "    ".repeat(indentLevel);
    }

    private String getOriginalText(org.antlr.v4.runtime.ParserRuleContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        return ctx.start.getInputStream().getText(new Interval(a, b));
    }

    @Override
    public String visitStart(StartContext ctx) {
        StringBuilder sb = new StringBuilder();
        sb.append("# Código generado desde EBDA\n\n");
        for (StatementContext stmt : ctx.statement()) {
            sb.append(visit(stmt));
        }
        return sb.toString();
    }

    @Override
    public String visitStatement(StatementContext ctx) {
        return visitChildren(ctx);
    }

    @Override
    public String visitDeclaration(DeclarationContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        String valor = visit(ctx.expression());
        return indent() + id + " = " + valor + "\n";
    }

    @Override
    public String visitAssignment(AssignmentContext ctx) {
        String texto = ctx.getText();
        if (texto.startsWith("buffear")) {
            String id = ctx.IDENTIFIER().getText();
            return indent() + id + " += 1\n";
        }
        if (texto.startsWith("nerfear")) {
            String id = ctx.IDENTIFIER().getText();
            return indent() + id + " -= 1\n";
        }
        String id = ctx.IDENTIFIER().getText();
        String valor = visit(ctx.expression());
        return indent() + id + " = " + valor + "\n";
    }

    @Override
    public String visitPrintStmt(PrintStmtContext ctx) {
        String valor = visit(ctx.expression());
        return indent() + "print(" + valor + ")\n";
    }

    @Override
    public String visitRushStmt(RushStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        String condicion = visit(ctx.expression());
        sb.append(indent()).append("if ").append(condicion).append(":\n");
        indentLevel++;
        if (ctx.ifBlock.isEmpty()) {
            sb.append(indent()).append("pass\n");
        } else {
            for (StatementContext s : ctx.ifBlock)
                sb.append(visit(s));
        }
        indentLevel--;
        if (!ctx.afkBlock.isEmpty()) {
            sb.append(indent()).append("else:\n");
            indentLevel++;
            for (StatementContext s : ctx.afkBlock)
                sb.append(visit(s));
            indentLevel--;
        }
        return sb.toString();
    }

    @Override
    public String visitRespawnStmt(RespawnStmtContext ctx) {
        StringBuilder sb = new StringBuilder();
        String condicion = visit(ctx.expression());
        sb.append(indent()).append("while ").append(condicion).append(":\n");
        indentLevel++;
        if (ctx.statement().isEmpty()) {
            sb.append(indent()).append("pass\n");
        } else {
            for (StatementContext s : ctx.statement())
                sb.append(visit(s));
        }
        indentLevel--;
        return sb.toString();
    }

    @Override
    public String visitWinStmt(WinStmtContext ctx) {
        String valor = visit(ctx.expression());
        return indent() + "print('Resultado final: ' + str(" + valor + "))\n";
    }

    @Override
    public String visitExpression(ExpressionContext ctx) {
        // negación lógica
        if (ctx.getChildCount() == 2 && ctx.getChild(0).getText().equals("!")) {
            return "not " + visit(ctx.expression(0));
        }
        // agrupación
        if (ctx.getChildCount() == 3
                && ctx.getChild(0).getText().equals("(")
                && ctx.getChild(2).getText().equals(")")) {
            return "(" + visit(ctx.expression(0)) + ")";
        }
        // operación binaria
        if (ctx.getChildCount() == 3 && ctx.expression().size() == 2) {
            String izq = visit(ctx.expression(0));
            String der = visit(ctx.expression(1));
            String op = ctx.getChild(1).getText();
            // en EBDA = es comparación, en Python es ==
            if (op.equals("="))
                op = "==";
            return izq + " " + op + " " + der;
        }
        // literales
        if (ctx.NUMBER() != null)
            return ctx.NUMBER().getText();
        if (ctx.STRING() != null)
            return ctx.STRING().getText();
        if (ctx.getText().equals("online"))
            return "True";
        if (ctx.getText().equals("offline"))
            return "False";
        if (ctx.getText().equals("npc"))
            return "None";
        if (ctx.IDENTIFIER() != null)
            return ctx.IDENTIFIER().getText();
        return "";
    }

    @Override
    public String visitType(TypeContext ctx) {
        return ctx.getText();
    }
}