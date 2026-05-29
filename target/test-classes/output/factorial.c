// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int n = 5;
    int resultado = 1;
    int i = 1;
    int corriendo = 1;
    while (corriendo) {
        resultado = resultado * i;
        i++;
        corriendo = i < n;
    }
    resultado = resultado * n;
    printf("%s\n", "Factorial de 5:");
    printf("%d\n", resultado);
    return resultado;
    return 0;
}
