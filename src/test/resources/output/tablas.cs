// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int tabla = 7;
        int i = 1;
        bool corriendo = true;
        Console.WriteLine("Tabla del 7:");
        while (corriendo) {
            int resultado = tabla * i;
            Console.WriteLine(resultado);
            i++;
            corriendo = i < 10;
        }
        resultado = tabla * 10;
        Console.WriteLine(resultado);
        return;
    }
}
