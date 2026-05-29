// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int a = 48;
        int b = 18;
        int temp = 0;
        bool corriendo = true;
        Console.WriteLine("MCD de 48 y 18:");
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
        Console.WriteLine(a);
        return;
    }
}
