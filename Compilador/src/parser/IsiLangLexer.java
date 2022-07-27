// Generated from IsiLang.g4 by ANTLR 4.10.1
package parser;

	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, WS=14, COMMENT=15, ID=16, NUM=17, 
		AP=18, FP=19, AC=20, FC=21, END=22, OP_REL=23, MAIS=24, MENOS=25, VEZES=26, 
		DIVIDIDO=27, MOD=28, ATR=29, TEXT=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "WS", "COMMENT", "ID", "NUM", "AP", 
			"FP", "AC", "FC", "END", "OP_REL", "MAIS", "MENOS", "VEZES", "DIVIDIDO", 
			"MOD", "ATR", "TEXT"
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
			if (v.getType() != Variable.STRING) {
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



	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001e\u00ee\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0098\b\u000e\n\u000e\f\u000e\u009b"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u00a3\b\u000e\n\u000e\f\u000e\u00a6\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00aa\b\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0003\u000f\u00af\b\u000f\u0001\u000f\u0005\u000f\u00b2\b\u000f\n\u000f"+
		"\f\u000f\u00b5\t\u000f\u0001\u0010\u0004\u0010\u00b8\b\u0010\u000b\u0010"+
		"\f\u0010\u00b9\u0001\u0010\u0001\u0010\u0004\u0010\u00be\b\u0010\u000b"+
		"\u0010\f\u0010\u00bf\u0003\u0010\u00c2\b\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u00d8\b\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0004\u001d"+
		"\u00e9\b\u001d\u000b\u001d\f\u001d\u00ea\u0001\u001d\u0001\u001d\u0002"+
		"\u0099\u00a4\u0000\u001e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d"+
		";\u001e\u0001\u0000\u0005\u0003\u0000\t\n\r\r  \u0002\u0000AZaz\u0003"+
		"\u000009AZaz\u0001\u000009\u0005\u0000 !#~\u00c0\u00d6\u00d8\u00f6\u00f8"+
		"\u00ff\u00fa\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0000"+
		"3\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001"+
		"\u0000\u0000\u0000\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000"+
		"\u0000\u0001=\u0001\u0000\u0000\u0000\u0003F\u0001\u0000\u0000\u0000\u0005"+
		"N\u0001\u0000\u0000\u0000\u0007V\u0001\u0000\u0000\u0000\tX\u0001\u0000"+
		"\u0000\u0000\u000b\\\u0001\u0000\u0000\u0000\rc\u0001\u0000\u0000\u0000"+
		"\u000fj\u0001\u0000\u0000\u0000\u0011o\u0001\u0000\u0000\u0000\u0013w"+
		"\u0001\u0000\u0000\u0000\u0015z\u0001\u0000\u0000\u0000\u0017\u0080\u0001"+
		"\u0000\u0000\u0000\u0019\u0086\u0001\u0000\u0000\u0000\u001b\u008f\u0001"+
		"\u0000\u0000\u0000\u001d\u00a9\u0001\u0000\u0000\u0000\u001f\u00ae\u0001"+
		"\u0000\u0000\u0000!\u00b7\u0001\u0000\u0000\u0000#\u00c3\u0001\u0000\u0000"+
		"\u0000%\u00c5\u0001\u0000\u0000\u0000\'\u00c7\u0001\u0000\u0000\u0000"+
		")\u00c9\u0001\u0000\u0000\u0000+\u00cb\u0001\u0000\u0000\u0000-\u00d7"+
		"\u0001\u0000\u0000\u0000/\u00d9\u0001\u0000\u0000\u00001\u00db\u0001\u0000"+
		"\u0000\u00003\u00dd\u0001\u0000\u0000\u00005\u00df\u0001\u0000\u0000\u0000"+
		"7\u00e1\u0001\u0000\u0000\u00009\u00e3\u0001\u0000\u0000\u0000;\u00e6"+
		"\u0001\u0000\u0000\u0000=>\u0005p\u0000\u0000>?\u0005r\u0000\u0000?@\u0005"+
		"o\u0000\u0000@A\u0005g\u0000\u0000AB\u0005r\u0000\u0000BC\u0005a\u0000"+
		"\u0000CD\u0005m\u0000\u0000DE\u0005a\u0000\u0000E\u0002\u0001\u0000\u0000"+
		"\u0000FG\u0005f\u0000\u0000GH\u0005i\u0000\u0000HI\u0005m\u0000\u0000"+
		"IJ\u0005p\u0000\u0000JK\u0005r\u0000\u0000KL\u0005o\u0000\u0000LM\u0005"+
		"g\u0000\u0000M\u0004\u0001\u0000\u0000\u0000NO\u0005d\u0000\u0000OP\u0005"+
		"e\u0000\u0000PQ\u0005c\u0000\u0000QR\u0005l\u0000\u0000RS\u0005a\u0000"+
		"\u0000ST\u0005r\u0000\u0000TU\u0005e\u0000\u0000U\u0006\u0001\u0000\u0000"+
		"\u0000VW\u0005,\u0000\u0000W\b\u0001\u0000\u0000\u0000XY\u0005i\u0000"+
		"\u0000YZ\u0005n\u0000\u0000Z[\u0005t\u0000\u0000[\n\u0001\u0000\u0000"+
		"\u0000\\]\u0005S\u0000\u0000]^\u0005t\u0000\u0000^_\u0005r\u0000\u0000"+
		"_`\u0005i\u0000\u0000`a\u0005n\u0000\u0000ab\u0005g\u0000\u0000b\f\u0001"+
		"\u0000\u0000\u0000cd\u0005d\u0000\u0000de\u0005o\u0000\u0000ef\u0005u"+
		"\u0000\u0000fg\u0005b\u0000\u0000gh\u0005l\u0000\u0000hi\u0005e\u0000"+
		"\u0000i\u000e\u0001\u0000\u0000\u0000jk\u0005l\u0000\u0000kl\u0005e\u0000"+
		"\u0000lm\u0005i\u0000\u0000mn\u0005a\u0000\u0000n\u0010\u0001\u0000\u0000"+
		"\u0000op\u0005e\u0000\u0000pq\u0005s\u0000\u0000qr\u0005c\u0000\u0000"+
		"rs\u0005r\u0000\u0000st\u0005e\u0000\u0000tu\u0005v\u0000\u0000uv\u0005"+
		"a\u0000\u0000v\u0012\u0001\u0000\u0000\u0000wx\u0005s\u0000\u0000xy\u0005"+
		"e\u0000\u0000y\u0014\u0001\u0000\u0000\u0000z{\u0005e\u0000\u0000{|\u0005"+
		"n\u0000\u0000|}\u0005t\u0000\u0000}~\u0005a\u0000\u0000~\u007f\u0005o"+
		"\u0000\u0000\u007f\u0016\u0001\u0000\u0000\u0000\u0080\u0081\u0005s\u0000"+
		"\u0000\u0081\u0082\u0005e\u0000\u0000\u0082\u0083\u0005n\u0000\u0000\u0083"+
		"\u0084\u0005a\u0000\u0000\u0084\u0085\u0005o\u0000\u0000\u0085\u0018\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005e\u0000\u0000\u0087\u0088\u0005n\u0000"+
		"\u0000\u0088\u0089\u0005q\u0000\u0000\u0089\u008a\u0005u\u0000\u0000\u008a"+
		"\u008b\u0005a\u0000\u0000\u008b\u008c\u0005n\u0000\u0000\u008c\u008d\u0005"+
		"t\u0000\u0000\u008d\u008e\u0005o\u0000\u0000\u008e\u001a\u0001\u0000\u0000"+
		"\u0000\u008f\u0090\u0007\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0006\r\u0000\u0000\u0092\u001c\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0005/\u0000\u0000\u0094\u0095\u0005/\u0000\u0000\u0095\u0099"+
		"\u0001\u0000\u0000\u0000\u0096\u0098\t\u0000\u0000\u0000\u0097\u0096\u0001"+
		"\u0000\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009c\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u00aa\u0005"+
		"\n\u0000\u0000\u009d\u009e\u0005/\u0000\u0000\u009e\u009f\u0005*\u0000"+
		"\u0000\u009f\u00a0\u0005*\u0000\u0000\u00a0\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a3\t\u0000\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005*\u0000\u0000\u00a8\u00aa"+
		"\u0005/\u0000\u0000\u00a9\u0093\u0001\u0000\u0000\u0000\u00a9\u009d\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0006"+
		"\u000e\u0000\u0000\u00ac\u001e\u0001\u0000\u0000\u0000\u00ad\u00af\u0007"+
		"\u0001\u0000\u0000\u00ae\u00ad\u0001\u0000\u0000\u0000\u00af\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b2\u0007\u0002\u0000\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4 \u0001\u0000"+
		"\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b8\u0007\u0003"+
		"\u0000\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00c1\u0001\u0000\u0000\u0000\u00bb\u00bd\u0005,\u0000"+
		"\u0000\u00bc\u00be\u0007\u0003\u0000\u0000\u00bd\u00bc\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bb\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\"\u0001\u0000\u0000\u0000\u00c3\u00c4\u0005(\u0000\u0000"+
		"\u00c4$\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005)\u0000\u0000\u00c6&"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005{\u0000\u0000\u00c8(\u0001\u0000"+
		"\u0000\u0000\u00c9\u00ca\u0005}\u0000\u0000\u00ca*\u0001\u0000\u0000\u0000"+
		"\u00cb\u00cc\u0005.\u0000\u0000\u00cc,\u0001\u0000\u0000\u0000\u00cd\u00d8"+
		"\u0005>\u0000\u0000\u00ce\u00cf\u0005>\u0000\u0000\u00cf\u00d8\u0005="+
		"\u0000\u0000\u00d0\u00d8\u0005<\u0000\u0000\u00d1\u00d2\u0005<\u0000\u0000"+
		"\u00d2\u00d8\u0005=\u0000\u0000\u00d3\u00d4\u0005=\u0000\u0000\u00d4\u00d8"+
		"\u0005=\u0000\u0000\u00d5\u00d6\u0005!\u0000\u0000\u00d6\u00d8\u0005="+
		"\u0000\u0000\u00d7\u00cd\u0001\u0000\u0000\u0000\u00d7\u00ce\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d0\u0001\u0000\u0000\u0000\u00d7\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d3\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d8.\u0001\u0000\u0000\u0000\u00d9\u00da\u0005+\u0000\u0000"+
		"\u00da0\u0001\u0000\u0000\u0000\u00db\u00dc\u0005-\u0000\u0000\u00dc2"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0005*\u0000\u0000\u00de4\u0001\u0000"+
		"\u0000\u0000\u00df\u00e0\u0005/\u0000\u0000\u00e06\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0005%\u0000\u0000\u00e28\u0001\u0000\u0000\u0000\u00e3\u00e4"+
		"\u0005:\u0000\u0000\u00e4\u00e5\u0005=\u0000\u0000\u00e5:\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e8\u0005\"\u0000\u0000\u00e7\u00e9\u0007\u0004\u0000"+
		"\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000"+
		"\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000"+
		"\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\"\u0000\u0000"+
		"\u00ed<\u0001\u0000\u0000\u0000\r\u0000\u0099\u00a4\u00a9\u00ae\u00b1"+
		"\u00b3\u00b9\u00bf\u00c1\u00d7\u00e8\u00ea\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}