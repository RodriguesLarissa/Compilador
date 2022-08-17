// Generated from /home/yudi/Documentos/COMP/Compilador/Compilador/IsiLang.g4 by ANTLR 4.9.2

	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;

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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, WS=19, COMMENT=20, ID=21, INT=22, DOUBLE=23, AP=24, FP=25, AC=26, 
		FC=27, END=28, OP_REL=29, MAIS=30, MENOS=31, VEZES=32, DIVIDIDO=33, MOD=34, 
		ATR=35, TEXT=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "WS", "COMMENT", "ID", "INT", "DOUBLE", "AP", "FP", "AC", "FC", 
			"END", "OP_REL", "MAIS", "MENOS", "VEZES", "DIVIDIDO", "MOD", "ATR", 
			"TEXT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "','", "'int'", "'String'", 
			"'double'", "'leia'", "'escreva'", "'se'", "'entao'", "'senao'", "'enquanto'", 
			"'escolha'", "'caso'", "':'", "'parar'", "'outro'", null, null, null, 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u011a\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00c1\n\25"+
		"\f\25\16\25\u00c4\13\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u00cc\n\25"+
		"\f\25\16\25\u00cf\13\25\3\25\3\25\5\25\u00d3\n\25\3\25\3\25\3\26\5\26"+
		"\u00d8\n\26\3\26\7\26\u00db\n\26\f\26\16\26\u00de\13\26\3\27\6\27\u00e1"+
		"\n\27\r\27\16\27\u00e2\3\30\6\30\u00e6\n\30\r\30\16\30\u00e7\3\30\3\30"+
		"\6\30\u00ec\n\30\r\30\16\30\u00ed\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3"+
		"\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0104"+
		"\n\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\6%\u0115\n%\r"+
		"%\16%\u0116\3%\3%\4\u00c2\u00cd\2&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&\3\2\7\5\2\13\f\17"+
		"\17\"\"\4\2C\\c|\5\2\62;C\\c|\3\2\62;\7\2\"#%\u0080\u00c2\u00d8\u00da"+
		"\u00f8\u00fa\u0101\2\u0126\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\3K\3\2\2\2\5T\3\2\2\2\7\\\3\2\2"+
		"\2\td\3\2\2\2\13f\3\2\2\2\rj\3\2\2\2\17q\3\2\2\2\21x\3\2\2\2\23}\3\2\2"+
		"\2\25\u0085\3\2\2\2\27\u0088\3\2\2\2\31\u008e\3\2\2\2\33\u0094\3\2\2\2"+
		"\35\u009d\3\2\2\2\37\u00a5\3\2\2\2!\u00aa\3\2\2\2#\u00ac\3\2\2\2%\u00b2"+
		"\3\2\2\2\'\u00b8\3\2\2\2)\u00d2\3\2\2\2+\u00d7\3\2\2\2-\u00e0\3\2\2\2"+
		"/\u00e5\3\2\2\2\61\u00ef\3\2\2\2\63\u00f1\3\2\2\2\65\u00f3\3\2\2\2\67"+
		"\u00f5\3\2\2\29\u00f7\3\2\2\2;\u0103\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2"+
		"\2\2A\u0109\3\2\2\2C\u010b\3\2\2\2E\u010d\3\2\2\2G\u010f\3\2\2\2I\u0112"+
		"\3\2\2\2KL\7r\2\2LM\7t\2\2MN\7q\2\2NO\7i\2\2OP\7t\2\2PQ\7c\2\2QR\7o\2"+
		"\2RS\7c\2\2S\4\3\2\2\2TU\7h\2\2UV\7k\2\2VW\7o\2\2WX\7r\2\2XY\7t\2\2YZ"+
		"\7q\2\2Z[\7i\2\2[\6\3\2\2\2\\]\7f\2\2]^\7g\2\2^_\7e\2\2_`\7n\2\2`a\7c"+
		"\2\2ab\7t\2\2bc\7g\2\2c\b\3\2\2\2de\7.\2\2e\n\3\2\2\2fg\7k\2\2gh\7p\2"+
		"\2hi\7v\2\2i\f\3\2\2\2jk\7U\2\2kl\7v\2\2lm\7t\2\2mn\7k\2\2no\7p\2\2op"+
		"\7i\2\2p\16\3\2\2\2qr\7f\2\2rs\7q\2\2st\7w\2\2tu\7d\2\2uv\7n\2\2vw\7g"+
		"\2\2w\20\3\2\2\2xy\7n\2\2yz\7g\2\2z{\7k\2\2{|\7c\2\2|\22\3\2\2\2}~\7g"+
		"\2\2~\177\7u\2\2\177\u0080\7e\2\2\u0080\u0081\7t\2\2\u0081\u0082\7g\2"+
		"\2\u0082\u0083\7x\2\2\u0083\u0084\7c\2\2\u0084\24\3\2\2\2\u0085\u0086"+
		"\7u\2\2\u0086\u0087\7g\2\2\u0087\26\3\2\2\2\u0088\u0089\7g\2\2\u0089\u008a"+
		"\7p\2\2\u008a\u008b\7v\2\2\u008b\u008c\7c\2\2\u008c\u008d\7q\2\2\u008d"+
		"\30\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090\u0091\7p\2\2\u0091"+
		"\u0092\7c\2\2\u0092\u0093\7q\2\2\u0093\32\3\2\2\2\u0094\u0095\7g\2\2\u0095"+
		"\u0096\7p\2\2\u0096\u0097\7s\2\2\u0097\u0098\7w\2\2\u0098\u0099\7c\2\2"+
		"\u0099\u009a\7p\2\2\u009a\u009b\7v\2\2\u009b\u009c\7q\2\2\u009c\34\3\2"+
		"\2\2\u009d\u009e\7g\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7e\2\2\u00a0\u00a1"+
		"\7q\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7j\2\2\u00a3\u00a4\7c\2\2\u00a4"+
		"\36\3\2\2\2\u00a5\u00a6\7e\2\2\u00a6\u00a7\7c\2\2\u00a7\u00a8\7u\2\2\u00a8"+
		"\u00a9\7q\2\2\u00a9 \3\2\2\2\u00aa\u00ab\7<\2\2\u00ab\"\3\2\2\2\u00ac"+
		"\u00ad\7r\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7t\2\2\u00af\u00b0\7c\2\2"+
		"\u00b0\u00b1\7t\2\2\u00b1$\3\2\2\2\u00b2\u00b3\7q\2\2\u00b3\u00b4\7w\2"+
		"\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7t\2\2\u00b6\u00b7\7q\2\2\u00b7&\3\2"+
		"\2\2\u00b8\u00b9\t\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\b\24\2\2\u00bb"+
		"(\3\2\2\2\u00bc\u00bd\7\61\2\2\u00bd\u00be\7\61\2\2\u00be\u00c2\3\2\2"+
		"\2\u00bf\u00c1\13\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2"+
		"\2\2\u00c5\u00d3\7\f\2\2\u00c6\u00c7\7\61\2\2\u00c7\u00c8\7,\2\2\u00c8"+
		"\u00c9\7,\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc\13\2\2\2\u00cb\u00ca\3\2"+
		"\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce"+
		"\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1\7,\2\2\u00d1\u00d3\7\61"+
		"\2\2\u00d2\u00bc\3\2\2\2\u00d2\u00c6\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d5\b\25\2\2\u00d5*\3\2\2\2\u00d6\u00d8\t\3\2\2\u00d7\u00d6\3\2\2\2"+
		"\u00d8\u00dc\3\2\2\2\u00d9\u00db\t\4\2\2\u00da\u00d9\3\2\2\2\u00db\u00de"+
		"\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd,\3\2\2\2\u00de"+
		"\u00dc\3\2\2\2\u00df\u00e1\t\5\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3.\3\2\2\2\u00e4\u00e6"+
		"\t\5\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7"+
		"\u00e8\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00eb\7.\2\2\u00ea\u00ec\t\5"+
		"\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\60\3\2\2\2\u00ef\u00f0\7*\2\2\u00f0\62\3\2\2\2\u00f1"+
		"\u00f2\7+\2\2\u00f2\64\3\2\2\2\u00f3\u00f4\7}\2\2\u00f4\66\3\2\2\2\u00f5"+
		"\u00f6\7\177\2\2\u00f68\3\2\2\2\u00f7\u00f8\7\60\2\2\u00f8:\3\2\2\2\u00f9"+
		"\u0104\7@\2\2\u00fa\u00fb\7@\2\2\u00fb\u0104\7?\2\2\u00fc\u0104\7>\2\2"+
		"\u00fd\u00fe\7>\2\2\u00fe\u0104\7?\2\2\u00ff\u0100\7?\2\2\u0100\u0104"+
		"\7?\2\2\u0101\u0102\7#\2\2\u0102\u0104\7?\2\2\u0103\u00f9\3\2\2\2\u0103"+
		"\u00fa\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u00fd\3\2\2\2\u0103\u00ff\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0104<\3\2\2\2\u0105\u0106\7-\2\2\u0106>\3\2"+
		"\2\2\u0107\u0108\7/\2\2\u0108@\3\2\2\2\u0109\u010a\7,\2\2\u010aB\3\2\2"+
		"\2\u010b\u010c\7\61\2\2\u010cD\3\2\2\2\u010d\u010e\7\'\2\2\u010eF\3\2"+
		"\2\2\u010f\u0110\7<\2\2\u0110\u0111\7?\2\2\u0111H\3\2\2\2\u0112\u0114"+
		"\7$\2\2\u0113\u0115\t\6\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116"+
		"\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7$"+
		"\2\2\u0119J\3\2\2\2\17\2\u00c2\u00cd\u00d2\u00d7\u00da\u00dc\u00e2\u00e7"+
		"\u00ed\u0103\u0114\u0116\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}