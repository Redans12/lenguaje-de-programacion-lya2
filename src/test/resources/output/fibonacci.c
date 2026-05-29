// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int n = 10;
    int a = 0;
    int b = 1;
    int i = 0;
    int temp = 0;
    int corriendo = 1;
    printf("%s\n", "Serie Fibonacci de 10 terminos:");
    printf("%d\n", a);
    printf("%d\n", b);
    while (corriendo) {
        temp = a + b;
        printf("%d\n", temp);
        a = b;
        b = temp;
        i++;
        corriendo = i < n;
    }
    return b;
    return 0;
}
