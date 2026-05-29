// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int n = 10;
    int suma = 0;
    int i = 1;
    bool corriendo = true;
    cout << "Sumatoria de 1 a 10:" << endl;
    while (corriendo) {
        suma = suma + i;
        i++;
        corriendo = i < n;
    }
    suma = suma + n;
    cout << suma << endl;
    return suma;
    return 0;
}
