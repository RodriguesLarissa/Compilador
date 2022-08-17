grammar IsiLang;

@header {
	import structures.*;
	import exceptions.*;
	import ast.*;
	import java.util.ArrayList;
	import java.util.Stack;
	import java.util.HashMap;
}

@members {
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

}

WS: (' ' | '\t' | '\n' | '\r') -> skip;
COMMENT: (('//' (.)*? '\n') | ('/**' (.)*? '*/')) -> skip;
ID: ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*;
INT: [0-9]+;
DOUBLE: [0-9]+ (',' [0-9]+);
// NUM: INT | DOUBLE; NUM: [0-9]+ (',' [0-9]+)?;

AP: '(';
FP: ')';
AC: '{';
FC: '}';
END: '.';

OP_REL: '>' | '>=' | '<' | '<=' | '==' | '!=';
MAIS: '+';
MENOS: '-';
VEZES: '*';
DIVIDIDO: '/';
MOD: '%';
ATR: ':=';

//TEXT: '"' ( [a-z] | [A-Z] | [0-9] | ' ')+ '"';

TEXT: '"' ( [#-~À-ÖØ-öø-ÿ] | '!' | ' ')+ '"';

/**
 prog: 'programa' declara bloco 'fimprog' END;
 
 declara: 'declare' tipo ID (',' ID)* END;
 
 bloco: (cmd)+;
 
 cmd: cmdleitura | cmdescrita | cmdexpr | cmdif | cmdwhile;
 */

prog:
	'programa' bloco 'fimprog' END {
		program.setVarTable(variableTable);
		program.setCmds(stack.pop());
		};

bloco:
	{
			currentThread = new ArrayList<AbstractCommand>();
			stack.push(currentThread);
			} (cmd)+;

cmd:
	cmdleitura
	| cmdescrita
	| cmdexpr
	| cmdif
	| cmdwhile
	| declara
	| cmdSwitch;

declara:
	'declare' tipo ID {
	_name = _input.LT(-1).getText();
	_value = null;
	_line = _input.LT(-1).getLine();
	_charPos = _input.LT(-1).getCharPositionInLine();
	verifyIdDeclaration();
} (
		',' ID {
	_name = _input.LT(-1).getText();
	_value = null;
	_line = _input.LT(-1).getLine();
	_charPos = _input.LT(-1).getCharPositionInLine();
	verifyIdDeclaration();
}
	)* END;

tipo:
	'int' {_type = Variable.INT;}
	| 'String' {_type = Variable.STRING;}
	| 'double' {_type = Variable.DOUBLE;};

cmdleitura:
	'leia' AP ID { 
		_name = _input.LT(-1).getText();
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine();
		verifyIdNotDeclared();
		_ID = _name;
		} FP END {
		_name = _ID;
		initializeVariable();
		Variable v = (Variable)variableTable.getVariable(_ID);
		CmdLeitura cmd = new CmdLeitura(_ID, v);
		stack.peek().add(cmd);
	};

cmdescrita:
	'escreva' AP (
		TEXT {
			_ID = _input.LT(-1).getText();
			_line = _input.LT(-1).getLine();
			_charPos = _input.LT(-1).getCharPositionInLine();
			verifyIdNotDeclared();
			}
		| ID { 
			_name = _input.LT(-1).getText();
			_line = _input.LT(-1).getLine();
			_charPos = _input.LT(-1).getCharPositionInLine();
			verifyIdNotDeclared();
			verifyVariableNotInitialized();
			addUsedVariables();_ID = _name;
			}
	) FP END {		
		CmdEscrita cmd = new CmdEscrita(_ID);
		stack.peek().add(cmd);
	};

cmdexpr:
	ID { 
		_name = _input.LT(-1).getText();
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine();
		verifyIdNotDeclared();
		_ID = _name;
		} ATR {
		_exprContent = "";
		} (
		{_lastTypeExpr = -1;} expr
		| {_lastTypeExpr = -1;} TEXT {
			_value = _input.LT(-1).getText();
			_line = _input.LT(-1).getLine();
			_charPos = _input.LT(-1).getCharPositionInLine();
			setValue(); 
			verifyIsStringAllowed();			
			verifyExprType(Variable.STRING);
			_exprContent = _value;
			}
	) END {
		_name = _ID;
		initializeVariable();
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine() - 1;
		verifyExprType(-1);
		CmdAtr cmd = new CmdAtr(_ID, _exprContent);
		stack.peek().add(cmd);
	};

cmdif:
	'se' AP {_exprCondition = "";_lastTypeExpr = -1;} expr OP_REL {_exprCondition += " " + _input.LT(-1).getText() + " ";
		_lastTypeExpr = -1;} expr FP {CmdDecisao cmd = new CmdDecisao();cmd.setCondition(_exprCondition);
		} 'entao' AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
		} (cmd)+ FC {cmd.setListTrue(stack.pop());} (
		'senao' AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);} (
			cmd
		)+ FC {cmd.setListFalse(stack.pop());}
	)? {		stack.peek().add(cmd);};

cmdwhile:
	'enquanto' AP {_exprCondition = "";_lastTypeExpr = -1;} expr OP_REL {_exprCondition += " " + _input.LT(-1).getText() + " ";
		_lastTypeExpr = -1;} expr FP {CmdLoop cmd = new CmdLoop();cmd.setCondition(_exprCondition);
		} AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
		} (cmd)+ FC {
		cmd.setCmds(stack.pop());
		stack.peek().add(cmd);
		};

cmdSwitch:
	'escolha' AP ID { 
		_name = _input.LT(-1).getText();
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine();
		verifyIdNotDeclared();
		verifySwitchType();
		addUsedVariables();
		_ID = _name;
		CmdSwitchCase cmd = new CmdSwitchCase(_name);
		} FP AC (
		'caso' {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);} (
			INT
			| DOUBLE
			| TEXT
		) {
			_case = _input.LT(-1).getText();
			int lH = _input.LT(-1).getLine();
			int cH = _input.LT(-1).getCharPositionInLine();
			} ':' (cmd)+ {switchCaseHelper = stack.pop();} (
			'parar' END {switchCaseHelper.add(new CmdBreak());}
		)? {
			_line = lH;
			_charPos = cH;		
			addCaseIfNotDeclared(cmd, _case, switchCaseHelper);}
	)+ (
		'outro' ':' {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);} (
			cmd
		)+ {cmd.setDfls(stack.pop());}
	) FC {stack.peek().add(cmd);};

expr: termo exprll;
exprll: exprl exprll |;
exprl: (MAIS | MENOS) { _exprContent += " " + _input.LT(-1).getText() + " "; _exprCondition += " " + _input.LT(-1).getText() + " ";		
		} termo;

termo: fator termoll;
termoll: termol termoll |;
termol: (VEZES | DIVIDIDO | MOD) { _exprContent += " " + _input.LT(-1).getText() + " "; _exprCondition += " " + _input.LT(-1).getText() + " ";
		} fator;

fator:
	INT { 
		_exprContent += _input.LT(-1).getText(); 
		_exprCondition += _input.LT(-1).getText();
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine();
		verifyExprType(Variable.INT); 
		}
	| DOUBLE { 
		_exprContent += _input.LT(-1).getText().replace(',', '.'); 
		_exprCondition += _input.LT(-1).getText().replace(',', '.');
		_line = _input.LT(-1).getLine();
		_charPos = _input.LT(-1).getCharPositionInLine();
		verifyExprType(Variable.DOUBLE);
		}
	| ID { 
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
	| AP {
 		_exprContent += _input.LT(-1).getText(); 
		_exprCondition += _input.LT(-1).getText(); 
		} expr FP {
 		_exprContent += _input.LT(-1).getText(); 
		_exprCondition += _input.LT(-1).getText(); 
		};

