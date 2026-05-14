grammar EBDA;

// ==================== PARSER RULES ====================

// Regla de inicio: un programa EBDA es una secuencia de cero o más instrucciones
start: statement* EOF;

// Una instrucción puede ser cualquiera de los siguientes tipos
statement:
	declaration // declaración de variable
	| assignment // asignación de valor
	| printStmt // impresión en pantalla
	| rushStmt // estructura de decisión (if/else)
	| respawnStmt // estructura de repetición (loop)
	| winStmt ; // retorno de valor

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
	'rush' '(' expression ')' '{' statement* '}' (
		'afk' '{' statement* '}'
	)?;

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
	expression ('+' | '-' | '*' | '/') expression // operaciones aritméticas
	| expression ('=' | '<' | '>') expression // comparaciones
	| '!' expression // negación lógica
	| '(' expression ')' // agrupación
	| IDENTIFIER // nombre de variable
	| NUMBER // número entero
	| STRING // cadena de texto
	| 'online' // valor booleano verdadero
	| 'offline' // valor booleano falso
	| 'npc' ; // valor nulo

// ==================== LEXER RULES ====================

// Identificadores: nombres de variables, deben iniciar con letra o ñ
IDENTIFIER: [a-zA-ZñÑ][a-zA-ZñÑ0-9_]*;

// Números enteros
NUMBER: [0-9]+;

// Cadenas de texto entre comillas dobles
STRING: '"' (~["\r\n])* '"';

// Delimitador de instrucción: :)
DELIM: ':)';

// Espacios en blanco, tabulaciones y saltos de línea son ignorados
WS: [ \t\r\n]+ -> skip;