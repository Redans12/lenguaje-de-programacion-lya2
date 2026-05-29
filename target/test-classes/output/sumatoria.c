// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int n = 10;
    int suma = 0;
    int i = 1;
    int corriendo = 1;
    printf("%s\n", "Sumatoria de 1 a 10:");
    while (corriendo) {
        suma = suma + i;
        i++;
        corriendo = i < n;
    }
    suma = suma + n;
    printf("%d\n", suma);
    return suma;
    return 0;
}
