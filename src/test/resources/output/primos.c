// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int n = 20;
    int i = 2;
    int buscando = 1;
    printf("%s\n", "Numeros primos hasta 20:");
    while (buscando) {
        int divisor = 2;
        int esPrimo = 1;
        int revisando = 1;
        while (revisando) {
            int modulo = i / divisor;
            modulo = modulo * divisor;
            if (modulo == i) {
                esPrimo = 0;
            }
            divisor++;
            revisando = divisor < i;
        }
        if (esPrimo == 1) {
            printf("%d\n", i);
        }
        i++;
        buscando = i < n;
    }
    return i;
    return 0;
}
