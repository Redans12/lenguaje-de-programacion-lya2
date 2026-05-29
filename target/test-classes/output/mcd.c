// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int a = 48;
    int b = 18;
    int temp = 0;
    int corriendo = 1;
    printf("%s\n", "MCD de 48 y 18:");
    while (corriendo) {
        if (b == 0) {
            corriendo = 0;
        } else {
            temp = b;
            b = a / b;
            b = b * temp;
            b = a - b;
            a = temp;
            corriendo = b > 0;
        }
    }
    printf("%d\n", a);
    return a;
    return 0;
}
