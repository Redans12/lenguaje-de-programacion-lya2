// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int tabla = 7;
    int i = 1;
    bool corriendo = true;
    cout << "Tabla del 7:" << endl;
    while (corriendo) {
        int resultado = tabla * i;
        cout << resultado << endl;
        i++;
        corriendo = i < 10;
    }
    resultado = tabla * 10;
    cout << resultado << endl;
    return resultado;
    return 0;
}
