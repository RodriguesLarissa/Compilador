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


	private ArrayList<AbstractCommand> switchCaseHelper;
	private String _case;

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

	public void addCaseIfNotDeclared(CmdSwitchCase obj,String id, ArrayList<AbstractCommand> cmds) {
		if (obj.existsCase(id)) {
			throw new SemanticException("Case '" + id + "' already declared");
		} else {
			obj.addCase(id, cmds);
		}
	}

	public void verifySwitchType() {
		if (_type != Variable.INT && _type != Variable.STRING) {
			throw new SemanticException("Only int or String are permitted on switch");
		}
	}
	public void setValue() {		
		v = variableTable.getVariable(_name);		
		v.setValue(_value);
	}	
	

	public void generateCodes(){
		program.generateJavaFile();
		program.generatePythonFile();
	}

}

WS: (' ' | '\t' | '\n' | '\r') -> skip;
COMMENT: (('//' (.)*? '\n') | ('/**' (.)*? '*/')) -> skip;
ID: ([a-z] | [A-Z]) ([a-z] | [A-Z] | [0-9])*;
NUM: [0-9]+ (',' [0-9]+)?;

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
	verifyIdDeclaration();
} (
		',' ID {
	_name = _input.LT(-1).getText();
	_value = null;
	verifyIdDeclaration();
}
	)* END;

tipo:
	'int' {_type = Variable.INT;}
	| 'String' {_type = Variable.STRING;}
	| 'double' {_type = Variable.DOUBLE;};

cmdleitura:
	'leia' AP ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();initializeVariable();_ID = _name;
		} FP END {
		Variable v = (Variable)variableTable.getVariable(_ID);
		CmdLeitura cmd = new CmdLeitura(_ID, v);
		stack.peek().add(cmd);
	};

cmdescrita:
	'escreva' AP (
		TEXT {_ID = _input.LT(-1).getText();verifyIdNotDeclared();}
		| ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();verifyVariableNotInitialized();_ID = _name;
			}
	) FP END {		
		CmdEscrita cmd = new CmdEscrita(_ID);
		stack.peek().add(cmd);
	};

cmdexpr:
	ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();initializeVariable();_ID = _name;
		} ATR {
		_exprContent = "";
		} (
		expr
		| TEXT {
			_value = _input.LT(-1).getText(); setValue(); verifyIsStringAllowed();_exprContent = _value;
			}
	) END {		
		CmdAtr cmd = new CmdAtr(_ID, _exprContent);
		stack.peek().add(cmd);
	};

cmdif:
	'se' AP {_exprCondition = "";} expr OP_REL {_exprCondition += " " + _input.LT(-1).getText() + " ";
		} expr FP {CmdDecisao cmd = new CmdDecisao();cmd.setCondition(_exprCondition);} 'entao' AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
		} (cmd)+ FC {cmd.setListTrue(stack.pop());} (
		'senao' AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);} (
			cmd
		)+ FC {cmd.setListFalse(stack.pop());}
	)? {		stack.peek().add(cmd);};

cmdwhile:
	'enquanto' AP {_exprCondition = "";} expr OP_REL {_exprCondition += " " + _input.LT(-1).getText() + " ";
		} expr FP {CmdLoop cmd = new CmdLoop();cmd.setCondition(_exprCondition);} AC {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);
		} (cmd)+ FC {
		cmd.setCmds(stack.pop());
		stack.peek().add(cmd);
		};
//putCaseIfNotDeclared(obj, id, cmd) setDfls
cmdSwitch:
	'switch' AP ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();initializeVariable();verifySwitchType();_ID = _name;
	CmdSwitchCase cmd = new CmdSwitchCase(_name);
		} FP AC (
		'case' {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);} (
			NUM
			| TEXT
		) {_case = _input.LT(-1).getText();} ':' (cmd)+ {switchCaseHelper = stack.pop();} (
			'break' END {switchCaseHelper.add(new CmdBreak());}
		)? {addCaseIfNotDeclared(cmd, _case, switchCaseHelper);}
	)+ (
		'default' ':' {currentThread = new ArrayList<AbstractCommand>();stack.push(currentThread);}
			(
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
	NUM {
		_exprContent += _input.LT(-1).getText().replace(',', '.'); _exprCondition += _input.LT(-1).getText().replace(',', '.');
		}
	| ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();verifyVariableNotInitialized(); _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
		}
	| AP { _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
		} expr FP { _exprContent += _input.LT(-1).getText(); _exprCondition += _input.LT(-1).getText();
		};

