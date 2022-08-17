// Generated from IsiLang.g4 by ANTLR 4.10.1
package parser;

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
		"\u0004\u0000$\u0119\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u00c0\b\u0013\n\u0013\f\u0013\u00c3"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0005\u0013\u00cb\b\u0013\n\u0013\f\u0013\u00ce\t\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00d2\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0003\u0014\u00d7\b\u0014\u0001\u0014\u0005\u0014\u00da\b\u0014\n\u0014"+
		"\f\u0014\u00dd\t\u0014\u0001\u0015\u0004\u0015\u00e0\b\u0015\u000b\u0015"+
		"\f\u0015\u00e1\u0001\u0016\u0004\u0016\u00e5\b\u0016\u000b\u0016\f\u0016"+
		"\u00e6\u0001\u0016\u0001\u0016\u0004\u0016\u00eb\b\u0016\u000b\u0016\f"+
		"\u0016\u00ec\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0103\b\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0004#\u0114\b#"+
		"\u000b#\f#\u0115\u0001#\u0001#\u0002\u00c1\u00cc\u0000$\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c9\u001d;\u001e=\u001f? A!C\"E#G$\u0001\u0000\u0005\u0003"+
		"\u0000\t\n\r\r  \u0002\u0000AZaz\u0003\u000009AZaz\u0001\u000009\u0005"+
		"\u0000 !#~\u00c0\u00d6\u00d8\u00f6\u00f8\u00ff\u0125\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000"+
		"\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C"+
		"\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000"+
		"\u0000\u0000\u0001I\u0001\u0000\u0000\u0000\u0003R\u0001\u0000\u0000\u0000"+
		"\u0005Z\u0001\u0000\u0000\u0000\u0007b\u0001\u0000\u0000\u0000\td\u0001"+
		"\u0000\u0000\u0000\u000bh\u0001\u0000\u0000\u0000\ro\u0001\u0000\u0000"+
		"\u0000\u000fv\u0001\u0000\u0000\u0000\u0011{\u0001\u0000\u0000\u0000\u0013"+
		"\u0083\u0001\u0000\u0000\u0000\u0015\u0086\u0001\u0000\u0000\u0000\u0017"+
		"\u008c\u0001\u0000\u0000\u0000\u0019\u0092\u0001\u0000\u0000\u0000\u001b"+
		"\u009b\u0001\u0000\u0000\u0000\u001d\u00a2\u0001\u0000\u0000\u0000\u001f"+
		"\u00a7\u0001\u0000\u0000\u0000!\u00a9\u0001\u0000\u0000\u0000#\u00af\u0001"+
		"\u0000\u0000\u0000%\u00b7\u0001\u0000\u0000\u0000\'\u00d1\u0001\u0000"+
		"\u0000\u0000)\u00d6\u0001\u0000\u0000\u0000+\u00df\u0001\u0000\u0000\u0000"+
		"-\u00e4\u0001\u0000\u0000\u0000/\u00ee\u0001\u0000\u0000\u00001\u00f0"+
		"\u0001\u0000\u0000\u00003\u00f2\u0001\u0000\u0000\u00005\u00f4\u0001\u0000"+
		"\u0000\u00007\u00f6\u0001\u0000\u0000\u00009\u0102\u0001\u0000\u0000\u0000"+
		";\u0104\u0001\u0000\u0000\u0000=\u0106\u0001\u0000\u0000\u0000?\u0108"+
		"\u0001\u0000\u0000\u0000A\u010a\u0001\u0000\u0000\u0000C\u010c\u0001\u0000"+
		"\u0000\u0000E\u010e\u0001\u0000\u0000\u0000G\u0111\u0001\u0000\u0000\u0000"+
		"IJ\u0005p\u0000\u0000JK\u0005r\u0000\u0000KL\u0005o\u0000\u0000LM\u0005"+
		"g\u0000\u0000MN\u0005r\u0000\u0000NO\u0005a\u0000\u0000OP\u0005m\u0000"+
		"\u0000PQ\u0005a\u0000\u0000Q\u0002\u0001\u0000\u0000\u0000RS\u0005f\u0000"+
		"\u0000ST\u0005i\u0000\u0000TU\u0005m\u0000\u0000UV\u0005p\u0000\u0000"+
		"VW\u0005r\u0000\u0000WX\u0005o\u0000\u0000XY\u0005g\u0000\u0000Y\u0004"+
		"\u0001\u0000\u0000\u0000Z[\u0005d\u0000\u0000[\\\u0005e\u0000\u0000\\"+
		"]\u0005c\u0000\u0000]^\u0005l\u0000\u0000^_\u0005a\u0000\u0000_`\u0005"+
		"r\u0000\u0000`a\u0005e\u0000\u0000a\u0006\u0001\u0000\u0000\u0000bc\u0005"+
		",\u0000\u0000c\b\u0001\u0000\u0000\u0000de\u0005i\u0000\u0000ef\u0005"+
		"n\u0000\u0000fg\u0005t\u0000\u0000g\n\u0001\u0000\u0000\u0000hi\u0005"+
		"S\u0000\u0000ij\u0005t\u0000\u0000jk\u0005r\u0000\u0000kl\u0005i\u0000"+
		"\u0000lm\u0005n\u0000\u0000mn\u0005g\u0000\u0000n\f\u0001\u0000\u0000"+
		"\u0000op\u0005d\u0000\u0000pq\u0005o\u0000\u0000qr\u0005u\u0000\u0000"+
		"rs\u0005b\u0000\u0000st\u0005l\u0000\u0000tu\u0005e\u0000\u0000u\u000e"+
		"\u0001\u0000\u0000\u0000vw\u0005l\u0000\u0000wx\u0005e\u0000\u0000xy\u0005"+
		"i\u0000\u0000yz\u0005a\u0000\u0000z\u0010\u0001\u0000\u0000\u0000{|\u0005"+
		"e\u0000\u0000|}\u0005s\u0000\u0000}~\u0005c\u0000\u0000~\u007f\u0005r"+
		"\u0000\u0000\u007f\u0080\u0005e\u0000\u0000\u0080\u0081\u0005v\u0000\u0000"+
		"\u0081\u0082\u0005a\u0000\u0000\u0082\u0012\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0005s\u0000\u0000\u0084\u0085\u0005e\u0000\u0000\u0085\u0014\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0005e\u0000\u0000\u0087\u0088\u0005n\u0000"+
		"\u0000\u0088\u0089\u0005t\u0000\u0000\u0089\u008a\u0005a\u0000\u0000\u008a"+
		"\u008b\u0005o\u0000\u0000\u008b\u0016\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005s\u0000\u0000\u008d\u008e\u0005e\u0000\u0000\u008e\u008f\u0005n"+
		"\u0000\u0000\u008f\u0090\u0005a\u0000\u0000\u0090\u0091\u0005o\u0000\u0000"+
		"\u0091\u0018\u0001\u0000\u0000\u0000\u0092\u0093\u0005e\u0000\u0000\u0093"+
		"\u0094\u0005n\u0000\u0000\u0094\u0095\u0005q\u0000\u0000\u0095\u0096\u0005"+
		"u\u0000\u0000\u0096\u0097\u0005a\u0000\u0000\u0097\u0098\u0005n\u0000"+
		"\u0000\u0098\u0099\u0005t\u0000\u0000\u0099\u009a\u0005o\u0000\u0000\u009a"+
		"\u001a\u0001\u0000\u0000\u0000\u009b\u009c\u0005s\u0000\u0000\u009c\u009d"+
		"\u0005w\u0000\u0000\u009d\u009e\u0005i\u0000\u0000\u009e\u009f\u0005t"+
		"\u0000\u0000\u009f\u00a0\u0005c\u0000\u0000\u00a0\u00a1\u0005h\u0000\u0000"+
		"\u00a1\u001c\u0001\u0000\u0000\u0000\u00a2\u00a3\u0005c\u0000\u0000\u00a3"+
		"\u00a4\u0005a\u0000\u0000\u00a4\u00a5\u0005s\u0000\u0000\u00a5\u00a6\u0005"+
		"e\u0000\u0000\u00a6\u001e\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005:\u0000"+
		"\u0000\u00a8 \u0001\u0000\u0000\u0000\u00a9\u00aa\u0005b\u0000\u0000\u00aa"+
		"\u00ab\u0005r\u0000\u0000\u00ab\u00ac\u0005e\u0000\u0000\u00ac\u00ad\u0005"+
		"a\u0000\u0000\u00ad\u00ae\u0005k\u0000\u0000\u00ae\"\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005d\u0000\u0000\u00b0\u00b1\u0005e\u0000\u0000\u00b1"+
		"\u00b2\u0005f\u0000\u0000\u00b2\u00b3\u0005a\u0000\u0000\u00b3\u00b4\u0005"+
		"u\u0000\u0000\u00b4\u00b5\u0005l\u0000\u0000\u00b5\u00b6\u0005t\u0000"+
		"\u0000\u00b6$\u0001\u0000\u0000\u0000\u00b7\u00b8\u0007\u0000\u0000\u0000"+
		"\u00b8\u00b9\u0001\u0000\u0000\u0000\u00b9\u00ba\u0006\u0012\u0000\u0000"+
		"\u00ba&\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005/\u0000\u0000\u00bc\u00bd"+
		"\u0005/\u0000\u0000\u00bd\u00c1\u0001\u0000\u0000\u0000\u00be\u00c0\t"+
		"\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000\u0000\u00c1\u00bf\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001"+
		"\u0000\u0000\u0000\u00c4\u00d2\u0005\n\u0000\u0000\u00c5\u00c6\u0005/"+
		"\u0000\u0000\u00c6\u00c7\u0005*\u0000\u0000\u00c7\u00c8\u0005*\u0000\u0000"+
		"\u00c8\u00cc\u0001\u0000\u0000\u0000\u00c9\u00cb\t\u0000\u0000\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd"+
		"\u00cf\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005*\u0000\u0000\u00d0\u00d2\u0005/\u0000\u0000\u00d1\u00bb\u0001"+
		"\u0000\u0000\u0000\u00d1\u00c5\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0006\u0013\u0000\u0000\u00d4(\u0001\u0000"+
		"\u0000\u0000\u00d5\u00d7\u0007\u0001\u0000\u0000\u00d6\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d7\u00db\u0001\u0000\u0000\u0000\u00d8\u00da\u0007\u0002"+
		"\u0000\u0000\u00d9\u00d8\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000"+
		"\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001\u0000"+
		"\u0000\u0000\u00dc*\u0001\u0000\u0000\u0000\u00dd\u00db\u0001\u0000\u0000"+
		"\u0000\u00de\u00e0\u0007\u0003\u0000\u0000\u00df\u00de\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00df\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2,\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e5\u0007\u0003\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0005,\u0000\u0000\u00e9\u00eb\u0007\u0003\u0000\u0000\u00ea"+
		"\u00e9\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed"+
		".\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005(\u0000\u0000\u00ef0\u0001"+
		"\u0000\u0000\u0000\u00f0\u00f1\u0005)\u0000\u0000\u00f12\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0005{\u0000\u0000\u00f34\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f5\u0005}\u0000\u0000\u00f56\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005"+
		".\u0000\u0000\u00f78\u0001\u0000\u0000\u0000\u00f8\u0103\u0005>\u0000"+
		"\u0000\u00f9\u00fa\u0005>\u0000\u0000\u00fa\u0103\u0005=\u0000\u0000\u00fb"+
		"\u0103\u0005<\u0000\u0000\u00fc\u00fd\u0005<\u0000\u0000\u00fd\u0103\u0005"+
		"=\u0000\u0000\u00fe\u00ff\u0005=\u0000\u0000\u00ff\u0103\u0005=\u0000"+
		"\u0000\u0100\u0101\u0005!\u0000\u0000\u0101\u0103\u0005=\u0000\u0000\u0102"+
		"\u00f8\u0001\u0000\u0000\u0000\u0102\u00f9\u0001\u0000\u0000\u0000\u0102"+
		"\u00fb\u0001\u0000\u0000\u0000\u0102\u00fc\u0001\u0000\u0000\u0000\u0102"+
		"\u00fe\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000\u0000\u0103"+
		":\u0001\u0000\u0000\u0000\u0104\u0105\u0005+\u0000\u0000\u0105<\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0005-\u0000\u0000\u0107>\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0005*\u0000\u0000\u0109@\u0001\u0000\u0000\u0000\u010a"+
		"\u010b\u0005/\u0000\u0000\u010bB\u0001\u0000\u0000\u0000\u010c\u010d\u0005"+
		"%\u0000\u0000\u010dD\u0001\u0000\u0000\u0000\u010e\u010f\u0005:\u0000"+
		"\u0000\u010f\u0110\u0005=\u0000\u0000\u0110F\u0001\u0000\u0000\u0000\u0111"+
		"\u0113\u0005\"\u0000\u0000\u0112\u0114\u0007\u0004\u0000\u0000\u0113\u0112"+
		"\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0113"+
		"\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0117"+
		"\u0001\u0000\u0000\u0000\u0117\u0118\u0005\"\u0000\u0000\u0118H\u0001"+
		"\u0000\u0000\u0000\r\u0000\u00c1\u00cc\u00d1\u00d6\u00d9\u00db\u00e1\u00e6"+
		"\u00ec\u0102\u0113\u0115\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}