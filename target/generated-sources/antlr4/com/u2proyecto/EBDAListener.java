// Generated from com/u2proyecto/EBDA.g4 by ANTLR 4.13.1
package com.u2proyecto;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EBDAParser}.
 */
public interface EBDAListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EBDAParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(EBDAParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(EBDAParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(EBDAParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(EBDAParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(EBDAParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(EBDAParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(EBDAParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(EBDAParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void enterPrintStmt(EBDAParser.PrintStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#printStmt}.
	 * @param ctx the parse tree
	 */
	void exitPrintStmt(EBDAParser.PrintStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#rushStmt}.
	 * @param ctx the parse tree
	 */
	void enterRushStmt(EBDAParser.RushStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#rushStmt}.
	 * @param ctx the parse tree
	 */
	void exitRushStmt(EBDAParser.RushStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#respawnStmt}.
	 * @param ctx the parse tree
	 */
	void enterRespawnStmt(EBDAParser.RespawnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#respawnStmt}.
	 * @param ctx the parse tree
	 */
	void exitRespawnStmt(EBDAParser.RespawnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#winStmt}.
	 * @param ctx the parse tree
	 */
	void enterWinStmt(EBDAParser.WinStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#winStmt}.
	 * @param ctx the parse tree
	 */
	void exitWinStmt(EBDAParser.WinStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(EBDAParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(EBDAParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EBDAParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(EBDAParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link EBDAParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(EBDAParser.ExpressionContext ctx);
}