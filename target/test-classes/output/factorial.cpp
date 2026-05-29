// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int n = 5;
    int resultado = 1;
    int i = 1;
    bool corriendo = true;
    while (corriendo) {
        resultado = resultado * i;
        i++;
        corriendo = i < n;
    }
    resultado = resultado * n;
    cout << "Factorial de 5:" << endl;
    cout << resultado << endl;
    return resultado;
    return 0;
}
