// Código generado desde EBDA

let n = 20;
let i = 2;
let buscando = true;
console.log("Numeros primos hasta 20:");
while (buscando) {
    let divisor = 2;
    let esPrimo = 1;
    let revisando = true;
    while (revisando) {
        let modulo = i / divisor;
        modulo = modulo * divisor;
        if (modulo === i) {
            esPrimo = 0;
        }
        divisor++;
        revisando = divisor < i;
    }
    if (esPrimo === 1) {
        console.log(i);
    }
    i++;
    buscando = i < n;
}
return i;
