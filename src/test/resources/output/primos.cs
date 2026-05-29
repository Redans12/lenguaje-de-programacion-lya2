// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int n = 20;
        int i = 2;
        bool buscando = true;
        Console.WriteLine("Numeros primos hasta 20:");
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
                Console.WriteLine(i);
            }
            i++;
            buscando = i < n;
        }
        return;
    }
}
