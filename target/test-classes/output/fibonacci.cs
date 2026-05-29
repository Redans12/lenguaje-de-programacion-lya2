// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int n = 10;
        int a = 0;
        int b = 1;
        int i = 0;
        int temp = 0;
        bool corriendo = true;
        Console.WriteLine("Serie Fibonacci de 10 terminos:");
        Console.WriteLine(a);
        Console.WriteLine(b);
        while (corriendo) {
            temp = a + b;
            Console.WriteLine(temp);
            a = b;
            b = temp;
            i++;
            corriendo = i < n;
        }
        return;
    }
}
