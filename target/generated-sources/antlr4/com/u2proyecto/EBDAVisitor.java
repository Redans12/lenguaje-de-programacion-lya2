// Generated from com/u2proyecto/EBDA.g4 by ANTLR 4.13.1
package com.u2proyecto;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EBDAParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EBDAVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EBDAParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(EBDAParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(EBDAParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(EBDAParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(EBDAParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#printStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintStmt(EBDAParser.PrintStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#rushStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRushStmt(EBDAParser.RushStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#respawnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRespawnStmt(EBDAParser.RespawnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#winStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWinStmt(EBDAParser.WinStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(EBDAParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EBDAParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(EBDAParser.ExpressionContext ctx);
}