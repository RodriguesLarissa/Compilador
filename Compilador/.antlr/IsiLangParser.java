// Generated from /home/yudi/Documentos/COMP/Compilador/Compilador/IsiLang.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

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
			null, "'programa'", "'fimprog'", "'declare'", "','", "'int'", "'string'", 
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
	}

	public final BlocoContext bloco() throws RecognitionException {
		BlocoContext _localctx = new BlocoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_bloco);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(39);
				cmd();
				}
				}
				setState(42); 
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
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(50);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				cmdleitura();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				cmdescrita();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				cmdexpr();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				cmdif();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				cmdwhile();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
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
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(T__2);
			setState(53);
			tipo();
			setState(54);
			match(ID);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(55);
				match(T__3);
				setState(56);
				match(ID);
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(62);
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
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_tipo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
	}

	public final CmdleituraContext cmdleitura() throws RecognitionException {
		CmdleituraContext _localctx = new CmdleituraContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdleitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__7);
			setState(67);
			match(AP);
			setState(68);
			match(ID);
			setState(69);
			match(FP);
			setState(70);
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
	}

	public final CmdescritaContext cmdescrita() throws RecognitionException {
		CmdescritaContext _localctx = new CmdescritaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdescrita);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(T__8);
			setState(73);
			match(AP);
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==ID || _la==TEXT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			match(FP);
			setState(76);
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

	public static class CmdexprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(IsiLangParser.ID, 0); }
		public TerminalNode ATR() { return getToken(IsiLangParser.ATR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode END() { return getToken(IsiLangParser.END, 0); }
		public CmdexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdexpr; }
	}

	public final CmdexprContext cmdexpr() throws RecognitionException {
		CmdexprContext _localctx = new CmdexprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdexpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(ID);
			setState(79);
			match(ATR);
			setState(80);
			expr();
			setState(81);
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
	}

	public final CmdifContext cmdif() throws RecognitionException {
		CmdifContext _localctx = new CmdifContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__9);
			setState(84);
			match(AP);
			setState(85);
			expr();
			setState(86);
			match(OP_REL);
			setState(87);
			expr();
			setState(88);
			match(FP);
			setState(89);
			match(T__10);
			setState(90);
			match(AC);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(91);
				cmd();
				}
				}
				setState(94); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(96);
			match(FC);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(97);
				match(T__11);
				setState(98);
				match(AC);
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					cmd();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
				setState(104);
				match(FC);
				}
			}

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
	}

	public final CmdwhileContext cmdwhile() throws RecognitionException {
		CmdwhileContext _localctx = new CmdwhileContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cmdwhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__12);
			setState(109);
			match(AP);
			setState(110);
			expr();
			setState(111);
			match(OP_REL);
			setState(112);
			expr();
			setState(113);
			match(FP);
			setState(114);
			match(AC);
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				cmd();
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12) | (1L << ID))) != 0) );
			setState(120);
			match(FC);
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
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			termo();
			setState(123);
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
	}

	public final ExprllContext exprll() throws RecognitionException {
		ExprllContext _localctx = new ExprllContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exprll);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIS:
			case MENOS:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				exprl();
				setState(126);
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
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==MAIS || _la==MENOS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(132);
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
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_termo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			fator();
			setState(135);
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
	}

	public final TermollContext termoll() throws RecognitionException {
		TermollContext _localctx = new TermollContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_termoll);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VEZES:
			case DIVIDIDO:
			case MOD:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				termol();
				setState(138);
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
	}

	public final TermolContext termol() throws RecognitionException {
		TermolContext _localctx = new TermolContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termol);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << VEZES) | (1L << DIVIDIDO) | (1L << MOD))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(144);
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
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fator);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(NUM);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				match(ID);
				}
				break;
			case AP:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				match(AP);
				setState(149);
				expr();
				setState(150);
				match(FP);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3 \u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\2\3\2\3\3\6\3+\n\3\r\3\16\3,\3\4\3\4\3\4\3\4\3\4\3\4\5"+
		"\4\65\n\4\3\5\3\5\3\5\3\5\3\5\7\5<\n\5\f\5\16\5?\13\5\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n_\n\n\r\n\16\n`\3\n\3\n\3\n\3\n"+
		"\6\ng\n\n\r\n\16\nh\3\n\3\n\5\nm\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\6\13w\n\13\r\13\16\13x\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r"+
		"\u0084\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0090"+
		"\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u009b\n\22\3\22"+
		"\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"\2\6\3\2\7\t\4\2\22\22"+
		"  \3\2\32\33\3\2\34\36\2\u009a\2$\3\2\2\2\4*\3\2\2\2\6\64\3\2\2\2\b\66"+
		"\3\2\2\2\nB\3\2\2\2\fD\3\2\2\2\16J\3\2\2\2\20P\3\2\2\2\22U\3\2\2\2\24"+
		"n\3\2\2\2\26|\3\2\2\2\30\u0083\3\2\2\2\32\u0085\3\2\2\2\34\u0088\3\2\2"+
		"\2\36\u008f\3\2\2\2 \u0091\3\2\2\2\"\u009a\3\2\2\2$%\7\3\2\2%&\5\4\3\2"+
		"&\'\7\4\2\2\'(\7\30\2\2(\3\3\2\2\2)+\5\6\4\2*)\3\2\2\2+,\3\2\2\2,*\3\2"+
		"\2\2,-\3\2\2\2-\5\3\2\2\2.\65\5\f\7\2/\65\5\16\b\2\60\65\5\20\t\2\61\65"+
		"\5\22\n\2\62\65\5\24\13\2\63\65\5\b\5\2\64.\3\2\2\2\64/\3\2\2\2\64\60"+
		"\3\2\2\2\64\61\3\2\2\2\64\62\3\2\2\2\64\63\3\2\2\2\65\7\3\2\2\2\66\67"+
		"\7\5\2\2\678\5\n\6\28=\7\22\2\29:\7\6\2\2:<\7\22\2\2;9\3\2\2\2<?\3\2\2"+
		"\2=;\3\2\2\2=>\3\2\2\2>@\3\2\2\2?=\3\2\2\2@A\7\30\2\2A\t\3\2\2\2BC\t\2"+
		"\2\2C\13\3\2\2\2DE\7\n\2\2EF\7\24\2\2FG\7\22\2\2GH\7\25\2\2HI\7\30\2\2"+
		"I\r\3\2\2\2JK\7\13\2\2KL\7\24\2\2LM\t\3\2\2MN\7\25\2\2NO\7\30\2\2O\17"+
		"\3\2\2\2PQ\7\22\2\2QR\7\37\2\2RS\5\26\f\2ST\7\30\2\2T\21\3\2\2\2UV\7\f"+
		"\2\2VW\7\24\2\2WX\5\26\f\2XY\7\31\2\2YZ\5\26\f\2Z[\7\25\2\2[\\\7\r\2\2"+
		"\\^\7\26\2\2]_\5\6\4\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2ab\3\2\2"+
		"\2bl\7\27\2\2cd\7\16\2\2df\7\26\2\2eg\5\6\4\2fe\3\2\2\2gh\3\2\2\2hf\3"+
		"\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\27\2\2km\3\2\2\2lc\3\2\2\2lm\3\2\2\2m\23"+
		"\3\2\2\2no\7\17\2\2op\7\24\2\2pq\5\26\f\2qr\7\31\2\2rs\5\26\f\2st\7\25"+
		"\2\2tv\7\26\2\2uw\5\6\4\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2yz\3"+
		"\2\2\2z{\7\27\2\2{\25\3\2\2\2|}\5\34\17\2}~\5\30\r\2~\27\3\2\2\2\177\u0080"+
		"\5\32\16\2\u0080\u0081\5\30\r\2\u0081\u0084\3\2\2\2\u0082\u0084\3\2\2"+
		"\2\u0083\177\3\2\2\2\u0083\u0082\3\2\2\2\u0084\31\3\2\2\2\u0085\u0086"+
		"\t\4\2\2\u0086\u0087\5\34\17\2\u0087\33\3\2\2\2\u0088\u0089\5\"\22\2\u0089"+
		"\u008a\5\36\20\2\u008a\35\3\2\2\2\u008b\u008c\5 \21\2\u008c\u008d\5\36"+
		"\20\2\u008d\u0090\3\2\2\2\u008e\u0090\3\2\2\2\u008f\u008b\3\2\2\2\u008f"+
		"\u008e\3\2\2\2\u0090\37\3\2\2\2\u0091\u0092\t\5\2\2\u0092\u0093\5\"\22"+
		"\2\u0093!\3\2\2\2\u0094\u009b\7\23\2\2\u0095\u009b\7\22\2\2\u0096\u0097"+
		"\7\24\2\2\u0097\u0098\5\26\f\2\u0098\u0099\7\25\2\2\u0099\u009b\3\2\2"+
		"\2\u009a\u0094\3\2\2\2\u009a\u0095\3\2\2\2\u009a\u0096\3\2\2\2\u009b#"+
		"\3\2\2\2\f,\64=`hlx\u0083\u008f\u009a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}