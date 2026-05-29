// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int n = 10;
    int a = 0;
    int b = 1;
    int i = 0;
    int temp = 0;
    bool corriendo = true;
    cout << "Serie Fibonacci de 10 terminos:" << endl;
    cout << a << endl;
    cout << b << endl;
    while (corriendo) {
        temp = a + b;
        cout << temp << endl;
        a = b;
        b = temp;
        i++;
        corriendo = i < n;
    }
    return b;
    return 0;
}
