// Código generado desde EBDA

let vida = 100;
let nivel = 1;
let contador = 0;
let nombre = "Jugador1";
let mensaje = "Hola";
let activo = true;
let vivo = true;
console.log(nombre);
console.log(vida);
console.log(activo);
vida = 90;
nombre = "HeroX";
activo = false;
console.log(vida);
console.log(nombre);
console.log(activo);
vida++;
console.log(vida);
vida--;
vida--;
console.log(vida);
let suma = vida + nivel;
let resta = vida - 10;
let producto = nivel * 5;
let division = vida / 3;
console.log(suma);
console.log(resta);
console.log(producto);
console.log(division);
let esMayor = vida > 50;
let esIgual = nivel === 1;
let esMenor = nivel < 10;
console.log(esMayor);
console.log(esIgual);
console.log(esMenor);
let noActivo = !activo;
console.log(noActivo);
let saludo = "Hola, " + nombre;
console.log(saludo);
if (esMayor) {
    console.log("vida mayor a 50");
    nivel++;
}
if (activo) {
    console.log("jugador activo");
} else {
    console.log("jugador inactivo");
}
if (esMayor) {
    console.log("vida > 50, revisando nivel...");
    if (esIgual) {
        console.log("nivel = 1 confirmado");
    } else {
        console.log("nivel distinto de 1");
    }
}
while (esMenor) {
    console.log(contador);
    contador++;
    nivel++;
    esMenor = nivel < 5;
}
if (esMayor) {
    console.log("entrando al respawn dentro de rush");
    let i = 0;
    let seguir = true;
    while (seguir) {
        i++;
        console.log(i);
        seguir = i < 3;
    }
}
let x = 0;
let corriendo = true;
while (corriendo) {
    x++;
    if (esMayor) {
        console.log("x subiendo, vida sigue alta");
    }
    corriendo = x < 4;
}
let fila = 0;
let loopFila = true;
while (loopFila) {
    fila++;
    let col = 0;
    let loopCol = true;
    while (loopCol) {
        col++;
        console.log(col);
        loopCol = col < 3;
    }
    loopFila = fila < 3;
}
return vida;
