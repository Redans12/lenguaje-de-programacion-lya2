// Código generado desde EBDA

let n = 10;
let a = 0;
let b = 1;
let i = 0;
let temp = 0;
let corriendo = true;
console.log("Serie Fibonacci de 10 terminos:");
console.log(a);
console.log(b);
while (corriendo) {
    temp = a + b;
    console.log(temp);
    a = b;
    b = temp;
    i++;
    corriendo = i < n;
}
return b;
