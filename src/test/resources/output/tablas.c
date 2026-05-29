// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int tabla = 7;
    int i = 1;
    int corriendo = 1;
    printf("%s\n", "Tabla del 7:");
    while (corriendo) {
        int resultado = tabla * i;
        printf("%d\n", resultado);
        i++;
        corriendo = i < 10;
    }
    resultado = tabla * 10;
    printf("%d\n", resultado);
    return resultado;
    return 0;
}
