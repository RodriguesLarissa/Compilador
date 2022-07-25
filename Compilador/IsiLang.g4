grammar IsiLang;

@header {
	import structures.*;
	import exceptions.*;
}

@members {
	private int _type;
	private String _name;
	private String _value;
	private VariableTable variableTable = new VariableTable();
	private Variable v;

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

TEXT: '"' ([a-z] | [A-Z] | [0-9] | ' ')+ '"';

/**
 prog: 'programa' declara bloco 'fimprog' END;
 
 declara: 'declare' tipo ID (',' ID)* END;
 
 bloco: (cmd)+;
 
 cmd: cmdleitura | cmdescrita | cmdexpr | cmdif | cmdwhile;
 */

prog: 'programa' bloco 'fimprog' END;

bloco: (cmd)+;

cmd:
	cmdleitura
	| cmdescrita
	| cmdexpr
	| cmdif
	| cmdwhile
	| declara;

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
	'leia' AP ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();} FP END;
cmdescrita:
	'escreva' AP (
		TEXT
		| ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();}
	) FP END;
cmdexpr:
	ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();} ATR (
		expr
		| TEXT {_value = _input.LT(-1).getText(); setValue(); verifyIsStringAllowed();}
	) END;
cmdif:
	'se' AP expr OP_REL expr FP 'entao' AC cmd+ FC (
		'senao' AC cmd+ FC
	)?;
cmdwhile: 'enquanto' AP expr OP_REL expr FP AC cmd+ FC;

expr: termo exprll;
exprll: exprl exprll |;
exprl: (MAIS | MENOS) termo;

termo: fator termoll;
termoll: termol termoll |;
termol: (VEZES | DIVIDIDO | MOD) fator;
fator:
	NUM
	| ID { _name = _input.LT(-1).getText();verifyIdNotDeclared();}
	| AP expr FP;

