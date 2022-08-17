// Generated from IsiLang.g4 by ANTLR 4.10.1
package parser;

	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;

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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, WS=19, COMMENT=20, ID=21, INT=22, DOUBLE=23, AP=24, FP=25, AC=26, 
		FC=27, END=28, OP_REL=29, MAIS=30, MENOS=31, VEZES=32, DIVIDIDO=33, MOD=34, 
		ATR=35, TEXT=36;
	public static final int
		RULE_prog = 0, RULE_bloco = 1, RULE_cmd = 2, RULE_declara = 3, RULE_tipo = 4, 
		RULE_cmdleitura = 5, RULE_cmdescrita = 6, RULE_cmdexpr = 7, RULE_cmdif = 8, 
		RULE_cmdwhile = 9, RULE_cmdSwitch = 10, RULE_expr = 11, RULE_exprll = 12, 
		RULE_exprl = 13, RULE_termo = 14, RULE_termoll = 15, RULE_termol = 16, 
		RULE_fator = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "bloco", "cmd", "declara", "tipo", "cmdleitura", "cmdescrita", 
			"cmdexpr", "cmdif", "cmdwhile", "cmdSwitch", "expr", "exprll", "exprl", 
			"termo", "termoll", "termol", "fator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'int'", "'String'", 
			"'double'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'switch'", "'case'", "':'", "'break'", "'default'", null, null, null, 
			null, null, "'('", "')'", "'{'", "'}'", "'.'", null, "'+'", "'-'", "'*'", 
			"'/'", "'%'", "':='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "WS", "COMMENT", "ID", "INT", 
			"DOUBLE", "AP", "FP", "AC", "FC", "END", "OP_REL", "MAIS", "MENOS", "VEZES", 
			"DIVIDIDO", "MOD", "ATR", "TEXT"
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
		private int _lastTypeExpr;
		private String _name;
		private int _line = 0;
		private int _charPos = 0;
		private String _value;
		private VariableTable variableTable = new VariableTable();
		private VariableTable initializedVariables = new VariableTable();
		private VariableTable usedVariables = new VariableTable();
		private Variable v;

		private Program program = new Program();
		private ArrayList<AbstractCommand> currentThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _ID;
		private String _exprContent;
		private String _exprCondition;


		private ArrayList<AbstractCommand> switchCaseHelper;
		private String _case;

		public void verifyIdAlreadyDeclared() { 
			if(variableTable.exists(_name)) { 
				throw new SemanticException("Variable '" + _name + "' already declared"+ " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		public void verifyIdNotDeclared() { 
			if(!variableTable.exists(_name)) { 
				throw new SemanticException("Variable '" + _name + "' not declared" + " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		public void verifyVariableNotInitialized() {
			if(!initializedVariables.exists(_name)) {
				throw new SemanticException("Variable '" + _name + "' not initialized" + " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		public void initializeVariable() {
			if(!initializedVariables.exists(_name)) {
				initializedVariables.add(variableTable.getVariable(_name));
			}
		}

		

		public void addUsedVariables() {
			if(!usedVariables.exists(_name)) {
				usedVariables.add(variableTable.getVariable(_name));
			}
		}

		public void verifyIdDeclaration() {
			verifyIdAlreadyDeclared();
			v = new Variable(_name, _type, _value);
			variableTable.add(v);
		}
		
		public void verifyIsStringAllowed() {
			if (v.getType() != Variable.STRING) {
				throw new SemanticException("Expected " + v.getTypeText() + " value, recieved String '" + _value + "'" + " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		public void addCaseIfNotDeclared(CmdSwitchCase obj,String id, ArrayList<AbstractCommand> cmds) {
			if (obj.existsCase(id)) {
				throw new SemanticException("Case '" + id + "' already declared" + " (line: " + _line + ":" + (_charPos + 1)  + ")");
			} else {
				obj.addCase(id, cmds);
			}
		}

		public void verifySwitchType() {
			int tipo = variableTable.getVariable(_name).getType();
			if (tipo != Variable.INT && tipo != Variable.STRING) {
				throw new SemanticException("Only int or String are permitted on switch"+ " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		public void verifyExprType(int LT) {
			
			int lastVType;
			if (LT == -1) {
				lastVType = variableTable.getVariable(_name).getType();
			} else {
				lastVType = LT;
			}
			
			if (_lastTypeExpr == -1) {
				_lastTypeExpr = lastVType;
			} else if (_lastTypeExpr != lastVType) {
				throw new SemanticException("Incompatible Types" + " (line: " + _line + ":" + (_charPos + 1)  + ")");
			}
		}

		
		public void setValue() {		
			v = variableTable.getVariable(_name);		
			v.setValue(_value);
		}	
		
		
		public void verifyNotUsedVariables() {
			ArrayList<Variable> xs = variableTable.getAll();
			for (Variable v : xs) {
				if (!usedVariables.exists(v.getName())) {
					System.out.println("WARNING: Variable '" + v.getName() + "' declared but not used");
				}
			}
		}

		public void generateCodes(){
			verifyNotUsedVariables();
			program.generateJavaFile();
			program.generatePythonFile();
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
			setState(36);
			match(T__0);
			setState(37);
			bloco();
			setState(38);
			match(T__1);
			setState(39);
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
						
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				cmd();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
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
		public CmdSwitchContext cmdSwitch() {
			return getRuleContext(CmdSwitchContext.class,0);
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
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				cmdleitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				cmdexpr();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				cmdif();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				cmdwhile();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				declara();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				cmdSwitch();
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
			setState(57);
			match(T__2);
			setState(58);
			tipo();
			setState(59);
			match(ID);

				_name = _input.LT(-1).getText();
				_value = null;
				_line = _input.LT(-1).getLine();
				_charPos = _input.LT(-1).getCharPositionInLine();
				verifyIdDeclaration();

			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(61);
				match(T__3);
				setState(62);
				match(ID);

					_name = _input.LT(-1).getText();
					_value = null;
					_line = _input.LT(-1).getLine();
					_charPos = _input.LT(-1).getCharPositionInLine();
					verifyIdDeclaration();

				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(T__4);
				_type = Variable.INT;
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(T__5);
				_type = Variable.STRING;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
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
			setState(79);
			match(T__7);
			setState(80);
			match(AP);
			setState(81);
			match(ID);
			 
					_name = _input.LT(-1).getText();
					_line = _input.LT(-1).getLine();
					_charPos = _input.LT(-1).getCharPositionInLine();
					verifyIdNotDeclared();
					_ID = _name;
					
			setState(83);
			match(FP);
			setState(84);
			match(END);

					_name = _ID;
					initializeVariable();
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
			setState(87);
			match(T__8);
			setState(88);
			match(AP);
			setState(93);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TEXT:
				{
				setState(89);
				match(TEXT);

							_ID = _input.LT(-1).getText();
							_line = _input.LT(-1).getLine();
							_charPos = _input.LT(-1).getCharPositionInLine();
							verifyIdNotDeclared();
							
				}
				break;
			case ID:
				{
				setState(91);
				match(ID);
				 
							_name = _input.LT(-1).getText();
							_line = _input.LT(-1).getLine();
							_charPos = _input.LT(-1).getCharPositionInLine();
							verifyIdNotDeclared();
							verifyVariableNotInitialized();
							addUsedVariables();_ID = _name;
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(95);
			match(FP);
			setState(96);
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
			setState(99);
			match(ID);
			 
					_name = _input.LT(-1).getText();
					_line = _input.LT(-1).getLine();
					_charPos = _input.LT(-1).getCharPositionInLine();
					verifyIdNotDeclared();
					_ID = _name;
					
			setState(101);
			match(ATR);

					_exprContent = "";
					
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case INT:
			case DOUBLE:
			case AP:
				{
				_lastTypeExpr = -1;
				setState(104);
				expr();
				}
				break;
			case TEXT:
				{
				_lastTypeExpr = -1;
				setState(106);
				match(TEXT);

							_value = _input.LT(-1).getText();
							_line = _input.LT(-1).getLine();
							_charPos = _input.LT(-1).getCharPositionInLine();
							setValue(); 
							verifyIsStringAllowed();			
							verifyExprType(Variable.STRING);
							_exprContent = _value;
							
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(110);
			match(END);

					_name = _ID;
					initializeVariable();
					_line = _input.LT(-1).getLine();
					_charPos = _input.LT(-1).getCharPositionInLine() - 1;
					verifyExprType(-1);
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
			setState(113);
			match(T__9);
			setState(114);
			match(AP);
			_exprCondition = "";_lastTypeExpr = -1;
			setState(116);
			expr();
			setState(117);
			match(OP_REL);
			_exprCondition += " " + _input.LT(-1).getText() + " ";
					_lastTypeExpr = -1;
			setState(119);
			expr();
			setState(120);
			match(FP);
			CmdDecisao cmd = new CmdDecisao();cmd.setCondition(_exprCondition);
					
			setState(122);
			match(T__10);
			setState(123);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
					
			setState(126); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(125);
				cmd();
				}
				}
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(130);
			match(FC);
			cmd.setListTrue(stack.pop());
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(132);
				match(T__11);
				setState(133);
				match(AC);
				currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(135);
					cmd();
					}
					}
					setState(138); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
				setState(140);
				match(FC);
				cmd.setListFalse(stack.pop());
				}
			}

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
			setState(147);
			match(T__12);
			setState(148);
			match(AP);
			_exprCondition = "";_lastTypeExpr = -1;
			setState(150);
			expr();
			setState(151);
			match(OP_REL);
			_exprCondition += " " + _input.LT(-1).getText() + " ";
					_lastTypeExpr = -1;
			setState(153);
			expr();
			setState(154);
			match(FP);
			CmdLoop cmd = new CmdLoop();cmd.setCondition(_exprCondition);
					
			setState(156);
			match(AC);
			currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
					
			setState(159); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(158);
				cmd();
				}
				}
				setState(161); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			setState(163);
			match(FC);

					cmd.setCmds(stack.pop());
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

	public static class CmdSwitchContext extends ParserRuleContext {
		public TerminalNode AP() { return getToken(IsiLangParser.AP, 0); }
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode FP() { return getToken(IsiLangParser.FP, 0); }
		public TerminalNode AC() { return getToken(IsiLangParser.AC, 0); }
		public TerminalNode FC() { return getToken(IsiLangParser.FC, 0); }
		public List<TerminalNode> INT() { return getTokens(IsiLangParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(IsiLangParser.INT, i);
		}
		public List<TerminalNode> DOUBLE() { return getTokens(IsiLangParser.DOUBLE); }
		public TerminalNode DOUBLE(int i) {
			return getToken(IsiLangParser.DOUBLE, i);
		}
		public List<TerminalNode> TEXT() { return getTokens(IsiLangParser.TEXT); }
		public TerminalNode TEXT(int i) {
			return getToken(IsiLangParser.TEXT, i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(IsiLangParser.END); }
		public TerminalNode END(int i) {
			return getToken(IsiLangParser.END, i);
		}
		public CmdSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSwitch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).enterCmdSwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IsiLangListener ) ((IsiLangListener)listener).exitCmdSwitch(this);
		}
	}

	public final CmdSwitchContext cmdSwitch() throws RecognitionException {
		CmdSwitchContext _localctx = new CmdSwitchContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cmdSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__13);
			setState(167);
			match(AP);
			setState(168);
			match(ID);
			 
					_name = _input.LT(-1).getText();
					_line = _input.LT(-1).getLine();
					_charPos = _input.LT(-1).getCharPositionInLine();
					verifyIdNotDeclared();
					verifySwitchType();
					addUsedVariables();
					_ID = _name;
					CmdSwitchCase cmd = new CmdSwitchCase(_name);
					
			setState(170);
			match(FP);
			setState(171);
			match(AC);
			setState(190); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(172);
				match(T__14);
				currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
				setState(174);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << DOUBLE) | (1L << TEXT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}

							_case = _input.LT(-1).getText();
							int lH = _input.LT(-1).getLine();
							int cH = _input.LT(-1).getCharPositionInLine();
							
				setState(176);
				match(T__15);
				setState(178); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(177);
					cmd();
					}
					}
					setState(180); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
				switchCaseHelper = stack.pop();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(183);
					match(T__16);
					setState(184);
					match(END);
					switchCaseHelper.add(new CmdBreak());
					}
				}


							_line = lH;
							_charPos = cH;		
							addCaseIfNotDeclared(cmd, _case, switchCaseHelper);
				}
				}
				setState(192); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__14 );
			{
			setState(194);
			match(T__17);
			setState(195);
			match(T__15);
			currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
			setState(198); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(197);
				cmd();
				}
				}
				setState(200); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << T__13) | (1L << ID))) != 0) );
			cmd.setDfls(stack.pop());
			}
			setState(204);
			match(FC);
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
		enterRule(_localctx, 22, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			termo();
			setState(208);
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
		enterRule(_localctx, 24, RULE_exprll);
		try {
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIS:
			case MENOS:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				exprl();
				setState(211);
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
		enterRule(_localctx, 26, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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
					
			setState(218);
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
		enterRule(_localctx, 28, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			fator();
			setState(221);
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
		enterRule(_localctx, 30, RULE_termoll);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VEZES:
			case DIVIDIDO:
			case MOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				termol();
				setState(224);
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
		enterRule(_localctx, 32, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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
					
			setState(231);
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
		public TerminalNode INT() { return getToken(IsiLangParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(IsiLangParser.DOUBLE, 0); }
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
		enterRule(_localctx, 34, RULE_fator);
		try {
			setState(245);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(INT);
				 
						_exprContent += _input.LT(-1).getText(); 
						_exprCondition += _input.LT(-1).getText();
						_line = _input.LT(-1).getLine();
						_charPos = _input.LT(-1).getCharPositionInLine();
						verifyExprType(Variable.INT); 
						
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(DOUBLE);
				 
						_exprContent += _input.LT(-1).getText().replace(',', '.'); 
						_exprCondition += _input.LT(-1).getText().replace(',', '.');
						_line = _input.LT(-1).getLine();
						_charPos = _input.LT(-1).getCharPositionInLine();
						verifyExprType(Variable.DOUBLE);
						
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(237);
				match(ID);
				 
						_name = _input.LT(-1).getText();
						_line = _input.LT(-1).getLine();
						_charPos = _input.LT(-1).getCharPositionInLine();
						verifyIdNotDeclared();
						verifyVariableNotInitialized();
						addUsedVariables();		
						verifyExprType(-1);		
				 		_exprContent += _input.LT(-1).getText(); 
						_exprCondition += _input.LT(-1).getText(); 
						
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 4);
				{
				setState(239);
				match(AP);

				 		_exprContent += _input.LT(-1).getText(); 
						_exprCondition += _input.LT(-1).getText(); 
						
				setState(241);
				expr();
				setState(242);
				match(FP);

				 		_exprContent += _input.LT(-1).getText(); 
						_exprCondition += _input.LT(-1).getText(); 
						
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
		"\u0004\u0001$\u00f8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0004\u0001-\b\u0001\u000b\u0001\f\u0001.\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00028\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003A\b\u0003\n\u0003\f\u0003D\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0003\u0004N\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006^\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007m\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u007f\b\b\u000b"+
		"\b\f\b\u0080\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u0089"+
		"\b\b\u000b\b\f\b\u008a\u0001\b\u0001\b\u0001\b\u0003\b\u0090\b\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0004\t\u00a0\b\t\u000b\t\f\t\u00a1"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u00b3\b\n\u000b"+
		"\n\f\n\u00b4\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u00bb\b\n\u0001\n"+
		"\u0001\n\u0004\n\u00bf\b\n\u000b\n\f\n\u00c0\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u00c7\b\n\u000b\n\f\n\u00c8\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00d7\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003"+
		"\u000f\u00e4\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"\u0011\u00f6\b\u0011\u0001\u0011\u0000\u0000\u0012\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000"+
		"\u0003\u0002\u0000\u0016\u0017$$\u0001\u0000\u001e\u001f\u0001\u0000 "+
		"\"\u00fe\u0000$\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000"+
		"\u00047\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bM\u0001"+
		"\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fW\u0001\u0000\u0000\u0000"+
		"\u000ec\u0001\u0000\u0000\u0000\u0010q\u0001\u0000\u0000\u0000\u0012\u0093"+
		"\u0001\u0000\u0000\u0000\u0014\u00a6\u0001\u0000\u0000\u0000\u0016\u00cf"+
		"\u0001\u0000\u0000\u0000\u0018\u00d6\u0001\u0000\u0000\u0000\u001a\u00d8"+
		"\u0001\u0000\u0000\u0000\u001c\u00dc\u0001\u0000\u0000\u0000\u001e\u00e3"+
		"\u0001\u0000\u0000\u0000 \u00e5\u0001\u0000\u0000\u0000\"\u00f5\u0001"+
		"\u0000\u0000\u0000$%\u0005\u0001\u0000\u0000%&\u0003\u0002\u0001\u0000"+
		"&\'\u0005\u0002\u0000\u0000\'(\u0005\u001c\u0000\u0000()\u0006\u0000\uffff"+
		"\uffff\u0000)\u0001\u0001\u0000\u0000\u0000*,\u0006\u0001\uffff\uffff"+
		"\u0000+-\u0003\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003"+
		"\u0001\u0000\u0000\u000008\u0003\n\u0005\u000018\u0003\f\u0006\u00002"+
		"8\u0003\u000e\u0007\u000038\u0003\u0010\b\u000048\u0003\u0012\t\u0000"+
		"58\u0003\u0006\u0003\u000068\u0003\u0014\n\u000070\u0001\u0000\u0000\u0000"+
		"71\u0001\u0000\u0000\u000072\u0001\u0000\u0000\u000073\u0001\u0000\u0000"+
		"\u000074\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000076\u0001\u0000"+
		"\u0000\u00008\u0005\u0001\u0000\u0000\u00009:\u0005\u0003\u0000\u0000"+
		":;\u0003\b\u0004\u0000;<\u0005\u0015\u0000\u0000<B\u0006\u0003\uffff\uffff"+
		"\u0000=>\u0005\u0004\u0000\u0000>?\u0005\u0015\u0000\u0000?A\u0006\u0003"+
		"\uffff\uffff\u0000@=\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001\u0000\u0000"+
		"\u0000DB\u0001\u0000\u0000\u0000EF\u0005\u001c\u0000\u0000F\u0007\u0001"+
		"\u0000\u0000\u0000GH\u0005\u0005\u0000\u0000HN\u0006\u0004\uffff\uffff"+
		"\u0000IJ\u0005\u0006\u0000\u0000JN\u0006\u0004\uffff\uffff\u0000KL\u0005"+
		"\u0007\u0000\u0000LN\u0006\u0004\uffff\uffff\u0000MG\u0001\u0000\u0000"+
		"\u0000MI\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000N\t\u0001\u0000"+
		"\u0000\u0000OP\u0005\b\u0000\u0000PQ\u0005\u0018\u0000\u0000QR\u0005\u0015"+
		"\u0000\u0000RS\u0006\u0005\uffff\uffff\u0000ST\u0005\u0019\u0000\u0000"+
		"TU\u0005\u001c\u0000\u0000UV\u0006\u0005\uffff\uffff\u0000V\u000b\u0001"+
		"\u0000\u0000\u0000WX\u0005\t\u0000\u0000X]\u0005\u0018\u0000\u0000YZ\u0005"+
		"$\u0000\u0000Z^\u0006\u0006\uffff\uffff\u0000[\\\u0005\u0015\u0000\u0000"+
		"\\^\u0006\u0006\uffff\uffff\u0000]Y\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0005\u0019\u0000\u0000`a\u0005"+
		"\u001c\u0000\u0000ab\u0006\u0006\uffff\uffff\u0000b\r\u0001\u0000\u0000"+
		"\u0000cd\u0005\u0015\u0000\u0000de\u0006\u0007\uffff\uffff\u0000ef\u0005"+
		"#\u0000\u0000fl\u0006\u0007\uffff\uffff\u0000gh\u0006\u0007\uffff\uffff"+
		"\u0000hm\u0003\u0016\u000b\u0000ij\u0006\u0007\uffff\uffff\u0000jk\u0005"+
		"$\u0000\u0000km\u0006\u0007\uffff\uffff\u0000lg\u0001\u0000\u0000\u0000"+
		"li\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0005\u001c\u0000"+
		"\u0000op\u0006\u0007\uffff\uffff\u0000p\u000f\u0001\u0000\u0000\u0000"+
		"qr\u0005\n\u0000\u0000rs\u0005\u0018\u0000\u0000st\u0006\b\uffff\uffff"+
		"\u0000tu\u0003\u0016\u000b\u0000uv\u0005\u001d\u0000\u0000vw\u0006\b\uffff"+
		"\uffff\u0000wx\u0003\u0016\u000b\u0000xy\u0005\u0019\u0000\u0000yz\u0006"+
		"\b\uffff\uffff\u0000z{\u0005\u000b\u0000\u0000{|\u0005\u001a\u0000\u0000"+
		"|~\u0006\b\uffff\uffff\u0000}\u007f\u0003\u0004\u0002\u0000~}\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~\u0001\u0000\u0000"+
		"\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0005\u001b\u0000\u0000\u0083\u008f\u0006\b\uffff\uffff"+
		"\u0000\u0084\u0085\u0005\f\u0000\u0000\u0085\u0086\u0005\u001a\u0000\u0000"+
		"\u0086\u0088\u0006\b\uffff\uffff\u0000\u0087\u0089\u0003\u0004\u0002\u0000"+
		"\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\u001b\u0000\u0000"+
		"\u008d\u008e\u0006\b\uffff\uffff\u0000\u008e\u0090\u0001\u0000\u0000\u0000"+
		"\u008f\u0084\u0001\u0000\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006\b\uffff\uffff\u0000"+
		"\u0092\u0011\u0001\u0000\u0000\u0000\u0093\u0094\u0005\r\u0000\u0000\u0094"+
		"\u0095\u0005\u0018\u0000\u0000\u0095\u0096\u0006\t\uffff\uffff\u0000\u0096"+
		"\u0097\u0003\u0016\u000b\u0000\u0097\u0098\u0005\u001d\u0000\u0000\u0098"+
		"\u0099\u0006\t\uffff\uffff\u0000\u0099\u009a\u0003\u0016\u000b\u0000\u009a"+
		"\u009b\u0005\u0019\u0000\u0000\u009b\u009c\u0006\t\uffff\uffff\u0000\u009c"+
		"\u009d\u0005\u001a\u0000\u0000\u009d\u009f\u0006\t\uffff\uffff\u0000\u009e"+
		"\u00a0\u0003\u0004\u0002\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a4\u0005\u001b\u0000\u0000\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5"+
		"\u0013\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u000e\u0000\u0000\u00a7"+
		"\u00a8\u0005\u0018\u0000\u0000\u00a8\u00a9\u0005\u0015\u0000\u0000\u00a9"+
		"\u00aa\u0006\n\uffff\uffff\u0000\u00aa\u00ab\u0005\u0019\u0000\u0000\u00ab"+
		"\u00be\u0005\u001a\u0000\u0000\u00ac\u00ad\u0005\u000f\u0000\u0000\u00ad"+
		"\u00ae\u0006\n\uffff\uffff\u0000\u00ae\u00af\u0007\u0000\u0000\u0000\u00af"+
		"\u00b0\u0006\n\uffff\uffff\u0000\u00b0\u00b2\u0005\u0010\u0000\u0000\u00b1"+
		"\u00b3\u0003\u0004\u0002\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00ba\u0006\n\uffff\uffff\u0000\u00b7\u00b8\u0005\u0011\u0000\u0000\u00b8"+
		"\u00b9\u0005\u001c\u0000\u0000\u00b9\u00bb\u0006\n\uffff\uffff\u0000\u00ba"+
		"\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0006\n\uffff\uffff\u0000\u00bd"+
		"\u00bf\u0001\u0000\u0000\u0000\u00be\u00ac\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u0005\u0012\u0000\u0000\u00c3\u00c4\u0005\u0010\u0000\u0000\u00c4"+
		"\u00c6\u0006\n\uffff\uffff\u0000\u00c5\u00c7\u0003\u0004\u0002\u0000\u00c6"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00ca\u0001\u0000\u0000\u0000\u00ca\u00cb\u0006\n\uffff\uffff\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd\u0005\u001b\u0000\u0000\u00cd"+
		"\u00ce\u0006\n\uffff\uffff\u0000\u00ce\u0015\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0003\u001c\u000e\u0000\u00d0\u00d1\u0003\u0018\f\u0000\u00d1\u0017"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0003\u001a\r\u0000\u00d3\u00d4\u0003"+
		"\u0018\f\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u0019\u0001\u0000\u0000\u0000\u00d8\u00d9\u0007\u0001"+
		"\u0000\u0000\u00d9\u00da\u0006\r\uffff\uffff\u0000\u00da\u00db\u0003\u001c"+
		"\u000e\u0000\u00db\u001b\u0001\u0000\u0000\u0000\u00dc\u00dd\u0003\"\u0011"+
		"\u0000\u00dd\u00de\u0003\u001e\u000f\u0000\u00de\u001d\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0003 \u0010\u0000\u00e0\u00e1\u0003\u001e\u000f\u0000"+
		"\u00e1\u00e4\u0001\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e3\u00df\u0001\u0000\u0000\u0000\u00e3\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e4\u001f\u0001\u0000\u0000\u0000\u00e5\u00e6\u0007\u0002\u0000\u0000"+
		"\u00e6\u00e7\u0006\u0010\uffff\uffff\u0000\u00e7\u00e8\u0003\"\u0011\u0000"+
		"\u00e8!\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005\u0016\u0000\u0000\u00ea"+
		"\u00f6\u0006\u0011\uffff\uffff\u0000\u00eb\u00ec\u0005\u0017\u0000\u0000"+
		"\u00ec\u00f6\u0006\u0011\uffff\uffff\u0000\u00ed\u00ee\u0005\u0015\u0000"+
		"\u0000\u00ee\u00f6\u0006\u0011\uffff\uffff\u0000\u00ef\u00f0\u0005\u0018"+
		"\u0000\u0000\u00f0\u00f1\u0006\u0011\uffff\uffff\u0000\u00f1\u00f2\u0003"+
		"\u0016\u000b\u0000\u00f2\u00f3\u0005\u0019\u0000\u0000\u00f3\u00f4\u0006"+
		"\u0011\uffff\uffff\u0000\u00f4\u00f6\u0001\u0000\u0000\u0000\u00f5\u00e9"+
		"\u0001\u0000\u0000\u0000\u00f5\u00eb\u0001\u0000\u0000\u0000\u00f5\u00ed"+
		"\u0001\u0000\u0000\u0000\u00f5\u00ef\u0001\u0000\u0000\u0000\u00f6#\u0001"+
		"\u0000\u0000\u0000\u0011.7BM]l\u0080\u008a\u008f\u00a1\u00b4\u00ba\u00c0"+
		"\u00c8\u00d6\u00e3\u00f5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}