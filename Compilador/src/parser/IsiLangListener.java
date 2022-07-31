// Generated from Compilador/IsiLang.g4 by ANTLR 4.10.1
package parser;

	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IsiLangParser}.
 */
public interface IsiLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(IsiLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(IsiLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(IsiLangParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(IsiLangParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(IsiLangParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(IsiLangParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdleitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdleitura(IsiLangParser.CmdleituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdescrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdescrita(IsiLangParser.CmdescritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdexpr(IsiLangParser.CmdexprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdexpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdexpr(IsiLangParser.CmdexprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void enterCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdif}.
	 * @param ctx the parse tree
	 */
	void exitCmdif(IsiLangParser.CmdifContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#cmdwhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdwhile(IsiLangParser.CmdwhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(IsiLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprll}.
	 * @param ctx the parse tree
	 */
	void enterExprll(IsiLangParser.ExprllContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprll}.
	 * @param ctx the parse tree
	 */
	void exitExprll(IsiLangParser.ExprllContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(IsiLangParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(IsiLangParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(IsiLangParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termoll}.
	 * @param ctx the parse tree
	 */
	void enterTermoll(IsiLangParser.TermollContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termoll}.
	 * @param ctx the parse tree
	 */
	void exitTermoll(IsiLangParser.TermollContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#termol}.
	 * @param ctx the parse tree
	 */
	void enterTermol(IsiLangParser.TermolContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#termol}.
	 * @param ctx the parse tree
	 */
	void exitTermol(IsiLangParser.TermolContext ctx);
	/**
	 * Enter a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(IsiLangParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link IsiLangParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(IsiLangParser.FatorContext ctx);
}