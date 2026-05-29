// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
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
        Console.WriteLine("Factorial de 5:");
        Console.WriteLine(resultado);
        return;
    }
}
