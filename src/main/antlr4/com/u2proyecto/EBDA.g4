grammar EBDA;

// ==================== PARSER RULES ====================

// Regla de inicio: un programa EBDA es una secuencia de cero o más instrucciones
start: statement* EOF;

// Una instrucción puede ser cualquiera de los siguientes tipos
statement:
    declaration
    | assignment
    | printStmt
    | rushStmt
    | respawnStmt
    | winStmt;

// Declaración de variable: tipo nombre -> valor :) Ejemplo: plant healthpoints vida -> 100 :)
declaration: 'plant' type IDENTIFIER '->' expression ':)';

// Asignación de valor a una variable existente También soporta incremento (buffear) y decremento
// (nerfear)
assignment:
	IDENTIFIER '->' expression ':)' // asignación directa
	| 'buffear' IDENTIFIER ':)' // incremento en 1 (++)
	| 'nerfear' IDENTIFIER ':)' ; // decremento en 1 (--)

// Impresión en pantalla Ejemplo: ñ (nombre) :)
printStmt: 'ñ' '(' expression ')' ':)';

// Estructura de decisión con rama opcional Ejemplo: rush (vida > 0) { ... } afk { ... }
rushStmt:
    'rush' '(' expression ')' '{' ifBlock+=statement* '}'
    ('afk' '{' afkBlock+=statement* '}'  )?;

// Estructura de repetición mientras la condición sea verdadera Ejemplo: respawn (vida > 0) { ... }
respawnStmt: 'respawn' '(' expression ')' '{' statement* '}';

// Retorno de un valor al finalizar una función o bloque Ejemplo: win 0 :)
winStmt: 'win' expression ':)';

// Tipos de datos disponibles en el lenguaje
type:
	'healthpoints' // tipo entero
	| 'chat' // tipo cadena de texto
	| 'online' ; // tipo booleano

// Expresiones: operaciones aritméticas, comparaciones, valores y variables Las expresiones pueden
// anidarse usando paréntesis
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