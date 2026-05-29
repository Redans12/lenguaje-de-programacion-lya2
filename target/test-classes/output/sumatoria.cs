// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int n = 10;
        int suma = 0;
        int i = 1;
        bool corriendo = true;
        Console.WriteLine("Sumatoria de 1 a 10:");
        while (corriendo) {
            suma = suma + i;
            i++;
            corriendo = i < n;
        }
        suma = suma + n;
        Console.WriteLine(suma);
        return;
    }
}
