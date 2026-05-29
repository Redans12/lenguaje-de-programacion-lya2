// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int n = 20;
    int i = 2;
    bool buscando = true;
    cout << "Numeros primos hasta 20:" << endl;
    while (buscando) {
        int divisor = 2;
        int esPrimo = 1;
        bool revisando = true;
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
            cout << i << endl;
        }
        i++;
        buscando = i < n;
    }
    return i;
    return 0;
}
