// Código generado desde EBDA

let a = 48;
let b = 18;
let temp = 0;
let corriendo = true;
console.log("MCD de 48 y 18:");
while (corriendo) {
    if (b === 0) {
        corriendo = false;
    } else {
        temp = b;
        b = a / b;
        b = b * temp;
        b = a - b;
        a = temp;
        corriendo = b > 0;
    }
}
console.log(a);
return a;
