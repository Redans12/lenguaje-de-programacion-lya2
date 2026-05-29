// Código generado desde EBDA

let n = 10;
let suma = 0;
let i = 1;
let corriendo = true;
console.log("Sumatoria de 1 a 10:");
while (corriendo) {
    suma = suma + i;
    i++;
    corriendo = i < n;
}
suma = suma + n;
console.log(suma);
return suma;
