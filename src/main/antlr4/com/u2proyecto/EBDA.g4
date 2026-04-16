grammar EBDA;

// ==================== PARSER RULES ====================

start
    : statement* EOF
    ;

statement:
	declaration
	| assignment
	| printStmt
	| rushStmt
	| respawnStmt
	| winStmt;

declaration: 'plant' type IDENTIFIER '->' expression ':)';

assignment:
	IDENTIFIER '->' expression ':)'
	| 'buffear' IDENTIFIER ':)'
	| 'nerfear' IDENTIFIER ':)';

printStmt: 'ñ' '(' expression ')' ':)';

rushStmt:
	'rush' '(' expression ')' '{' statement* '}' (
		'afk' '{' statement* '}'
	)?;

respawnStmt: 'respawn' '(' expression ')' '{' statement* '}';

winStmt: 'win' expression ':)';

type: 'healthpoints' | 'chat' | 'online';

expression:
	expression ('+' | '-' | '*' | '/') expression
	| expression ('=' | '<' | '>') expression
	| '!' expression
	| '(' expression ')'
	| IDENTIFIER
	| NUMBER
	| STRING
	| 'online'
	| 'offline'
	| 'npc';

// ==================== LEXER RULES ====================

IDENTIFIER: [a-zA-ZñÑ][a-zA-ZñÑ0-9_]*;
NUMBER: [0-9]+;
STRING: '"' (~["\r\n])* '"';
DELIM: ':)';
WS: [ \t\r\n]+ -> skip;