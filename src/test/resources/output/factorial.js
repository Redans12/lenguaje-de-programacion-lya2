// Código generado desde EBDA

let n = 5;
let resultado = 1;
let i = 1;
let corriendo = true;
while (corriendo) {
    resultado = resultado * i;
    i++;
    corriendo = i < n;
}
resultado = resultado * n;
console.log("Factorial de 5:");
console.log(resultado);
return resultado;
