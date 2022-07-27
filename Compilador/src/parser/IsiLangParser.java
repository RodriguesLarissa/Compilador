// Generated from IsiLang.g4 by ANTLR 4.10.1
package parser;

	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, COMMENT=15, ID=16, NUM=17, 
		AP=18, FP=19, AC=20, FC=21, END=22, OP_REL=23, MAIS=24, MENOS=25, VEZES=26, 
		DIVIDIDO=27, MOD=28, ATR=29, TEXT=30;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_declara = 3, RULE_tipo = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdexpr = 7, RULE_cmdif = 8, 
		RULE_cmdwhile = 9, RULE_expr = 10, RULE_exprll = 11, RULE_exprl = 12, 
		RULE_termo = 13, RULE_termoll = 14, RULE_termol = 15, RULE_fator = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "declara", "tipo", "cmdleitura", "cmdescrita", 
			"cmdexpr", "cmdif", "cmdwhile", "expr", "exprll", "exprl", "termo", "termoll", 
			"termol", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'int'", "'String'", 
			"'double'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			null, null, null, null, "'('", "')'", "'{'", "'}'", "'.'", null, "'+'", 
			"'-'", "'*'", "'/'", "'%'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "WS", "COMMENT", "ID", "NUM", "AP", "FP", "AC", "FC", "END", 
			"OP_REL", "MAIS", "MENOS", "VEZES", "DIVIDIDO", "MOD", "ATR", "TEXT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


		private int _type;
		private String _name;
		private String _value;
		private VariableTable variableTable = new VariableTable();
		private VariableTable initializedVariables = new VariableTable();
		private Variable v;

		private Program program = new Program();
		private ArrayList<AbstractCommand> currentThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _ID;
		private String _exprContent;
		private String _exprCondition;
		private ArrayList<AbstractCommand> listTrue;
		private ArrayList<AbstractCommand> listFalse;
		private ArrayList<AbstractCommand> listWhile;


		public void verifyIdAlreadyDeclared() { 
			if(variableTable.exists(_name)) { 
				throw new SemanticException("Variable '" + _name + "' already declared");
			}
		}

		public void verifyIdNotDeclared() { 
			if(!variableTable.exists(_name)) { 
				throw new SemanticException("Variable '" + _name + "' not declared");
			}
		}

		public void verifyVariableNotInitialized() {
			if(!initializedVariables.exists(_name)) {
				throw new SemanticException("Variable '" + _name + "' not initialized");
			}
		}

		public void initializeVariable() {
			if(!initializedVariables.exists(_name)) {
				initializedVariables.add(variableTable.getVariable(_name));
			}
		}

		public void verifyIdDeclaration() {
			verifyIdAlreadyDeclared();
			v = new Variable(_name, _type, _value);
			variableTable.add(v);
		}
		
		public void verifyIsStringAllowed() {
			if (_type != Variable.STRING) {
				throw new SemanticException("Expected " + v.getTypeText() + " value, recieved String '" + _value + "'");
			}
		}

		public void setValue() {		
			v = variableTable.getVariable(_name);		
			v.setValue(_value);
		}
		

		public void generateCodes(){
			program.generateJavaFile();
		}


	public IsiLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public BlocoContext bloco() {
			return getRuleContext(BlocoContext.class,0);
		}
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(T__0);
			setState(35);
			bloco();
			setState(36);
			match(T__1);
			setState(37);
			match(END);

					program.setVarTable(variableTable);
					program.setCmds(stack.pop());
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlocoContext extends ParserRuleContext {
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public BlocoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloco; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterBloco(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitBloco(this);
		}
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

						currentThread = new ArrayList<AbstractCommand>();
						stack.push(currentThread);
						
			setState(42); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(41);
				cmd();
				}
				}
				setState(44); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdContext extends ParserRuleContext {
		public CmdleituraContext cmdleitura() {
			return getRuleContext(CmdleituraContext.class,0);
		}
		public CmdescritaContext cmdescrita() {
			return getRuleContext(CmdescritaContext.class,0);
		}
		public CmdexprContext cmdexpr() {
			return getRuleContext(CmdexprContext.class,0);
		}
		public CmdifContext cmdif() {
			return getRuleContext(CmdifContext.class,0);
		}
		public CmdwhileContext cmdwhile() {
			return getRuleContext(CmdwhileContext.class,0);
		}
		public DeclaraContext declara() {
			return getRuleContext(DeclaraContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmd(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(52);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				cmdleitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				cmdexpr();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				cmdif();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				cmdwhile();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				declara();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclaraContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(IsiLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(IsiLangParser.ID, i);
		}
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterDeclara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitDeclara(this);
		}
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(T__2);
			setState(55);
			tipo();
			setState(56);
			match(ID);

				_name = _input.LT(-1).getText();
				_value = null;
				verifyIdDeclaration();

			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(58);
				match(T__3);
				setState(59);
				match(ID);

					_name = _input.LT(-1).getText();
					_value = null;
					verifyIdDeclaration();

				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TipoContext extends ParserRuleContext {
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTipo(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		try {
			setState(74);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__4);
				_type = Variable.INT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(70);
				match(T__5);
				_type = Variable.STRING;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(T__6);
				_type = Variable.DOUBLE;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdleituraContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public CmdleituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdleitura; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdleitura(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdleitura(this);
		}
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__7);
			setState(77);
			match(AP);
			setState(78);
			match(ID);
			 _name = _input.LT(-1).getText();verifyIdNotDeclared();initializeVariable();_ID = _name;
					
			setState(80);
			match(FP);
			setState(81);
			match(END);

					Variable v = (Variable)variableTable.getVariable(_ID);
					CmdLeitura cmd = new CmdLeitura(_ID, v);
					stack.peek().add(cmd);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdescritaContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public CmdescritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdescrita; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdescrita(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdescrita(this);
		}
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdescrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__8);
			setState(85);
			match(AP);
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(86);
				match(TEXT);
				_ID = _input.LT(-1).getText();verifyIdNotDeclared();
				}
				break;
			case ID:
				{
				setState(88);
				match(ID);
				 _name = _input.LT(-1).getText();verifyIdNotDeclared();verifyVariableNotInitialized();_ID = _name;
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(92);
			match(FP);
			setState(93);
			match(END);
					
					CmdEscrita cmd = new CmdEscrita(_ID);
					stack.peek().add(cmd);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATR() { return getToken(IsiLangParser.ATR, 0); }
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode TEXT() { return getToken(IsiLangParser.TEXT, 0); }
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdexpr(this);
		}
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(ID);
			 _name = _input.LT(-1).getText();verifyIdNotDeclared();initializeVariable();_ID = _name;
					
			setState(98);
			match(ATR);

					_exprContent = "";
					
			setState(103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case NUM:
			case AP:
				{
				setState(100);
				expr();
				}
				break;
			case TEXT:
				{
				setState(101);
				match(TEXT);

							_value = _input.LT(-1).getText(); setValue(); verifyIsStringAllowed();_exprContent = _value;
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(105);
			match(END);
					
					CmdAtr cmd = new CmdAtr(_ID, _exprContent);
					stack.peek().add(cmd);
				
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdifContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(IsiLangParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public List<TerminalNode> AC() { return getTokens(IsiLangParser.AC); }
		public TerminalNode AC(int i) {
			return getToken(IsiLangParser.AC, i);
		}
		public List<TerminalNode> FC() { return getTokens(IsiLangParser.FC); }
		public TerminalNode FC(int i) {
			return getToken(IsiLangParser.FC, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdif(this);
		}
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__9);
			setState(109);
			match(AP);
			_exprCondition = "";
			setState(111);
			expr();
			setState(112);
			match(OP_REL);
			_exprCondition += " " + _input.LT(-1).getText() + " ";
					
			setState(114);
			expr();
			setState(115);
			match(FP);
			CmdDecisao cmd = new CmdDecisao();cmd.setCondition(_exprCondition);
			setState(117);
			match(T__10);
			setState(118);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
					
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				cmd();
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(125);
			match(FC);
			listTrue = stack.pop();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(127);
				match(T__11);
				setState(128);
				match(AC);
				currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(130);
					cmd();
					}
					}
					setState(133); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
				setState(135);
				match(FC);
				listFalse = stack.pop();
				}
			}


					cmd.setListTrue(listTrue);
					cmd.setListFalse(listFalse);
					stack.peek().add(cmd);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmdwhileContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(IsiLangParser.OP_REL, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdwhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdwhile; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdwhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdwhile(this);
		}
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__12);
			setState(143);
			match(AP);
			_exprCondition = "";
			setState(145);
			expr();
			setState(146);
			match(OP_REL);
			_exprCondition += " " + _input.LT(-1).getText() + " ";
					
			setState(148);
			expr();
			setState(149);
			match(FP);
			CmdLoop cmd = new CmdLoop();cmd.setCondition(_exprCondition);
			setState(151);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
					
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				cmd();
				}
				}
				setState(156); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(158);
			match(FC);
			listWhile = stack.pop();
					cmd.setCmds(listWhile);
					stack.peek().add(cmd);
					
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprllContext exprll() {
			return getRuleContext(ExprllContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			termo();
			setState(162);
			exprll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprllContext extends ParserRuleContext {
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprllContext exprll() {
			return getRuleContext(ExprllContext.class,0);
		}
		public ExprllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExprll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExprll(this);
		}
	}

	public final ExprllContext exprll() throws RecognitionException {
		ExprllContext _localctx = new ExprllContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprll);
		try {
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIS:
			case MENOS:
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				exprl();
				setState(165);
				exprll();
				}
				break;
			case FP:
			case END:
			case OP_REL:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprlContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public TerminalNode MAIS() { return getToken(IsiLangParser.MAIS, 0); }
		public TerminalNode MENOS() { return getToken(IsiLangParser.MENOS, 0); }
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterExprl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitExprl(this);
		}
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !(_la==MAIS || _la==MENOS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprContent += " " + _input.LT(-1).getText() + " "; _exprCondition += " " + _input.LT(-1).getText() + " ";		
					
			setState(172);
			termo();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TermollContext termoll() {
			return getRuleContext(TermollContext.class,0);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermo(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			fator();
			setState(175);
			termoll();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermollContext extends ParserRuleContext {
		public TermolContext termol() {
			return getRuleContext(TermolContext.class,0);
		}
		public TermollContext termoll() {
			return getRuleContext(TermollContext.class,0);
		}
		public TermollContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termoll; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermoll(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermoll(this);
		}
	}

	public final TermollContext termoll() throws RecognitionException {
		TermollContext _localctx = new TermollContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termoll);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VEZES:
			case DIVIDIDO:
			case MOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				termol();
				setState(178);
				termoll();
				}
				break;
			case FP:
			case END:
			case OP_REL:
			case MAIS:
			case MENOS:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermolContext extends ParserRuleContext {
		public FatorContext fator() {
			return getRuleContext(FatorContext.class,0);
		}
		public TerminalNode VEZES() { return getToken(IsiLangParser.VEZES, 0); }
		public TerminalNode DIVIDIDO() { return getToken(IsiLangParser.DIVIDIDO, 0); }
		public TerminalNode MOD() { return getToken(IsiLangParser.MOD, 0); }
		public TermolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterTermol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitTermol(this);
		}
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VEZES) | (1L << DIVIDIDO) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			 _exprContent += " " + _input.LT(-1).getText() + " "; _exprCondition += " " + _input.LT(-1).getText() + " ";
					
			setState(185);
			fator();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FatorContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(IsiLangParser.NUM, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitFator(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fator);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(NUM);
				 _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
						
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(ID);
				 _name = _input.LT(-1).getText();verifyIdNotDeclared();verifyVariableNotInitialized(); _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
						
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(AP);
				 _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
						
				setState(193);
				expr();
				setState(194);
				match(FP);
				 _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
						
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0004\u0001+\b"+
		"\u0001\u000b\u0001\f\u0001,\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u00025\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0005"+
		"\u0003>\b\u0003\n\u0003\f\u0003A\t\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004K\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006[\b\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007h\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0004\bz\b\b\u000b\b\f\b{\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0004\b\u0084\b\b\u000b\b\f\b\u0085\u0001\b\u0001\b\u0001\b\u0003\b"+
		"\u008b\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u009b\b\t\u000b"+
		"\t\f\t\u009c\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00a9\b\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00b6\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00c6\b\u0010\u0001\u0010\u0000\u0000\u0011\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000"+
		"\u0002\u0001\u0000\u0018\u0019\u0001\u0000\u001a\u001c\u00c9\u0000\"\u0001"+
		"\u0000\u0000\u0000\u0002(\u0001\u0000\u0000\u0000\u00044\u0001\u0000\u0000"+
		"\u0000\u00066\u0001\u0000\u0000\u0000\bJ\u0001\u0000\u0000\u0000\nL\u0001"+
		"\u0000\u0000\u0000\fT\u0001\u0000\u0000\u0000\u000e`\u0001\u0000\u0000"+
		"\u0000\u0010l\u0001\u0000\u0000\u0000\u0012\u008e\u0001\u0000\u0000\u0000"+
		"\u0014\u00a1\u0001\u0000\u0000\u0000\u0016\u00a8\u0001\u0000\u0000\u0000"+
		"\u0018\u00aa\u0001\u0000\u0000\u0000\u001a\u00ae\u0001\u0000\u0000\u0000"+
		"\u001c\u00b5\u0001\u0000\u0000\u0000\u001e\u00b7\u0001\u0000\u0000\u0000"+
		" \u00c5\u0001\u0000\u0000\u0000\"#\u0005\u0001\u0000\u0000#$\u0003\u0002"+
		"\u0001\u0000$%\u0005\u0002\u0000\u0000%&\u0005\u0016\u0000\u0000&\'\u0006"+
		"\u0000\uffff\uffff\u0000\'\u0001\u0001\u0000\u0000\u0000(*\u0006\u0001"+
		"\uffff\uffff\u0000)+\u0003\u0004\u0002\u0000*)\u0001\u0000\u0000\u0000"+
		"+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000"+
		"\u0000-\u0003\u0001\u0000\u0000\u0000.5\u0003\n\u0005\u0000/5\u0003\f"+
		"\u0006\u000005\u0003\u000e\u0007\u000015\u0003\u0010\b\u000025\u0003\u0012"+
		"\t\u000035\u0003\u0006\u0003\u00004.\u0001\u0000\u0000\u00004/\u0001\u0000"+
		"\u0000\u000040\u0001\u0000\u0000\u000041\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000043\u0001\u0000\u0000\u00005\u0005\u0001\u0000\u0000"+
		"\u000067\u0005\u0003\u0000\u000078\u0003\b\u0004\u000089\u0005\u0010\u0000"+
		"\u00009?\u0006\u0003\uffff\uffff\u0000:;\u0005\u0004\u0000\u0000;<\u0005"+
		"\u0010\u0000\u0000<>\u0006\u0003\uffff\uffff\u0000=:\u0001\u0000\u0000"+
		"\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000@B\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005"+
		"\u0016\u0000\u0000C\u0007\u0001\u0000\u0000\u0000DE\u0005\u0005\u0000"+
		"\u0000EK\u0006\u0004\uffff\uffff\u0000FG\u0005\u0006\u0000\u0000GK\u0006"+
		"\u0004\uffff\uffff\u0000HI\u0005\u0007\u0000\u0000IK\u0006\u0004\uffff"+
		"\uffff\u0000JD\u0001\u0000\u0000\u0000JF\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000K\t\u0001\u0000\u0000\u0000LM\u0005\b\u0000\u0000MN"+
		"\u0005\u0012\u0000\u0000NO\u0005\u0010\u0000\u0000OP\u0006\u0005\uffff"+
		"\uffff\u0000PQ\u0005\u0013\u0000\u0000QR\u0005\u0016\u0000\u0000RS\u0006"+
		"\u0005\uffff\uffff\u0000S\u000b\u0001\u0000\u0000\u0000TU\u0005\t\u0000"+
		"\u0000UZ\u0005\u0012\u0000\u0000VW\u0005\u001e\u0000\u0000W[\u0006\u0006"+
		"\uffff\uffff\u0000XY\u0005\u0010\u0000\u0000Y[\u0006\u0006\uffff\uffff"+
		"\u0000ZV\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\]\u0005\u0013\u0000\u0000]^\u0005\u0016\u0000\u0000^_\u0006"+
		"\u0006\uffff\uffff\u0000_\r\u0001\u0000\u0000\u0000`a\u0005\u0010\u0000"+
		"\u0000ab\u0006\u0007\uffff\uffff\u0000bc\u0005\u001d\u0000\u0000cg\u0006"+
		"\u0007\uffff\uffff\u0000dh\u0003\u0014\n\u0000ef\u0005\u001e\u0000\u0000"+
		"fh\u0006\u0007\uffff\uffff\u0000gd\u0001\u0000\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0005\u0016\u0000\u0000jk\u0006"+
		"\u0007\uffff\uffff\u0000k\u000f\u0001\u0000\u0000\u0000lm\u0005\n\u0000"+
		"\u0000mn\u0005\u0012\u0000\u0000no\u0006\b\uffff\uffff\u0000op\u0003\u0014"+
		"\n\u0000pq\u0005\u0017\u0000\u0000qr\u0006\b\uffff\uffff\u0000rs\u0003"+
		"\u0014\n\u0000st\u0005\u0013\u0000\u0000tu\u0006\b\uffff\uffff\u0000u"+
		"v\u0005\u000b\u0000\u0000vw\u0005\u0014\u0000\u0000wy\u0006\b\uffff\uffff"+
		"\u0000xz\u0003\u0004\u0002\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{y\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000}~\u0005\u0015\u0000\u0000~\u008a\u0006\b\uffff\uffff"+
		"\u0000\u007f\u0080\u0005\f\u0000\u0000\u0080\u0081\u0005\u0014\u0000\u0000"+
		"\u0081\u0083\u0006\b\uffff\uffff\u0000\u0082\u0084\u0003\u0004\u0002\u0000"+
		"\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000"+
		"\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000"+
		"\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088\u0005\u0015\u0000\u0000"+
		"\u0088\u0089\u0006\b\uffff\uffff\u0000\u0089\u008b\u0001\u0000\u0000\u0000"+
		"\u008a\u007f\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0006\b\uffff\uffff\u0000"+
		"\u008d\u0011\u0001\u0000\u0000\u0000\u008e\u008f\u0005\r\u0000\u0000\u008f"+
		"\u0090\u0005\u0012\u0000\u0000\u0090\u0091\u0006\t\uffff\uffff\u0000\u0091"+
		"\u0092\u0003\u0014\n\u0000\u0092\u0093\u0005\u0017\u0000\u0000\u0093\u0094"+
		"\u0006\t\uffff\uffff\u0000\u0094\u0095\u0003\u0014\n\u0000\u0095\u0096"+
		"\u0005\u0013\u0000\u0000\u0096\u0097\u0006\t\uffff\uffff\u0000\u0097\u0098"+
		"\u0005\u0014\u0000\u0000\u0098\u009a\u0006\t\uffff\uffff\u0000\u0099\u009b"+
		"\u0003\u0004\u0002\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009c"+
		"\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005\u0015\u0000\u0000\u009f\u00a0\u0006\t\uffff\uffff\u0000\u00a0\u0013"+
		"\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003\u001a\r\u0000\u00a2\u00a3\u0003"+
		"\u0016\u000b\u0000\u00a3\u0015\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003"+
		"\u0018\f\u0000\u00a5\u00a6\u0003\u0016\u000b\u0000\u00a6\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u0017\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0007\u0000\u0000\u0000\u00ab\u00ac\u0006\f\uffff"+
		"\uffff\u0000\u00ac\u00ad\u0003\u001a\r\u0000\u00ad\u0019\u0001\u0000\u0000"+
		"\u0000\u00ae\u00af\u0003 \u0010\u0000\u00af\u00b0\u0003\u001c\u000e\u0000"+
		"\u00b0\u001b\u0001\u0000\u0000\u0000\u00b1\u00b2\u0003\u001e\u000f\u0000"+
		"\u00b2\u00b3\u0003\u001c\u000e\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b6\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b6\u001d\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0007\u0001\u0000\u0000\u00b8\u00b9\u0006\u000f\uffff\uffff"+
		"\u0000\u00b9\u00ba\u0003 \u0010\u0000\u00ba\u001f\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0005\u0011\u0000\u0000\u00bc\u00c6\u0006\u0010\uffff\uffff"+
		"\u0000\u00bd\u00be\u0005\u0010\u0000\u0000\u00be\u00c6\u0006\u0010\uffff"+
		"\uffff\u0000\u00bf\u00c0\u0005\u0012\u0000\u0000\u00c0\u00c1\u0006\u0010"+
		"\uffff\uffff\u0000\u00c1\u00c2\u0003\u0014\n\u0000\u00c2\u00c3\u0005\u0013"+
		"\u0000\u0000\u00c3\u00c4\u0006\u0010\uffff\uffff\u0000\u00c4\u00c6\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bb\u0001\u0000\u0000\u0000\u00c5\u00bd\u0001"+
		"\u0000\u0000\u0000\u00c5\u00bf\u0001\u0000\u0000\u0000\u00c6!\u0001\u0000"+
		"\u0000\u0000\r,4?JZg{\u0085\u008a\u009c\u00a8\u00b5\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}