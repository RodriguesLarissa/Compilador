grammar IsiLang;
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

prog: 'programa' declara bloco 'fimprog' END;
declara: 'declare' tipo ID (',' ID)* END;
bloco: (cmd)+;
cmd: cmdleitura | cmdescrita | cmdexpr | cmdif | cmdwhile;

/**
 // Habilitar para permitir declaração mais de 1 vez e em diversos lugares do código
 
 prog: 'programa' bloco 'fimprog' END;
 
 bloco: (cmd)+;
 
 cmd: cmdleitura | cmdescrita | cmdexpr | cmdif | cmdwhile | declara;
 
 declara: 'declare' tipo ID (',' ID)* END;
 */
tipo: 'int' | 'string' | 'double';
cmdleitura: 'leia' AP ID FP END;
cmdescrita: 'escreva' AP (TEXT | ID) FP END;
cmdexpr: ID ATR expr END;
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
fator: NUM | ID | AP expr FP;

