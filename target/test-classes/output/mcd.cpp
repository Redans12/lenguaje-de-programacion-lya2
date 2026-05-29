// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int a = 48;
    int b = 18;
    int temp = 0;
    bool corriendo = true;
    cout << "MCD de 48 y 18:" << endl;
    while (corriendo) {
        if (b == 0) {
            corriendo = false;
        } else {
            temp = b;
            b = a / b;
            b = b * temp;
            b = a - b;
            a = temp;
            corriendo = b > 0;
        }
    }
    cout << a << endl;
    return a;
    return 0;
}
