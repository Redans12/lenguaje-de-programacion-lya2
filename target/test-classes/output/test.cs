// Código generado desde EBDA
using System;

class Program {
    static void Main(string[] args) {
        int vida = 100;
        int nivel = 1;
        int contador = 0;
        string nombre = "Jugador1";
        string mensaje = "Hola";
        bool activo = true;
        bool vivo = true;
        Console.WriteLine(nombre);
        Console.WriteLine(vida);
        Console.WriteLine(activo);
        vida = 90;
        nombre = "HeroX";
        activo = false;
        Console.WriteLine(vida);
        Console.WriteLine(nombre);
        Console.WriteLine(activo);
        vida++;
        Console.WriteLine(vida);
        vida--;
        vida--;
        Console.WriteLine(vida);
        int suma = vida + nivel;
        int resta = vida - 10;
        int producto = nivel * 5;
        int division = vida / 3;
        Console.WriteLine(suma);
        Console.WriteLine(resta);
        Console.WriteLine(producto);
        Console.WriteLine(division);
        bool esMayor = vida > 50;
        bool esIgual = nivel == 1;
        bool esMenor = nivel < 10;
        Console.WriteLine(esMayor);
        Console.WriteLine(esIgual);
        Console.WriteLine(esMenor);
        bool noActivo = !activo;
        Console.WriteLine(noActivo);
        string saludo = "Hola, " + nombre;
        Console.WriteLine(saludo);
        if (esMayor) {
            Console.WriteLine("vida mayor a 50");
            nivel++;
        }
        if (activo) {
            Console.WriteLine("jugador activo");
        } else {
            Console.WriteLine("jugador inactivo");
        }
        if (esMayor) {
            Console.WriteLine("vida > 50, revisando nivel...");
            if (esIgual) {
                Console.WriteLine("nivel = 1 confirmado");
            } else {
                Console.WriteLine("nivel distinto de 1");
            }
        }
        while (esMenor) {
            Console.WriteLine(contador);
            contador++;
            nivel++;
            esMenor = nivel < 5;
        }
        if (esMayor) {
            Console.WriteLine("entrando al respawn dentro de rush");
            int i = 0;
            bool seguir = true;
            while (seguir) {
                i++;
                Console.WriteLine(i);
                seguir = i < 3;
            }
        }
        int x = 0;
        bool corriendo = true;
        while (corriendo) {
            x++;
            if (esMayor) {
                Console.WriteLine("x subiendo, vida sigue alta");
            }
            corriendo = x < 4;
        }
        int fila = 0;
        bool loopFila = true;
        while (loopFila) {
            fila++;
            int col = 0;
            bool loopCol = true;
            while (loopCol) {
                col++;
                Console.WriteLine(col);
                loopCol = col < 3;
            }
            loopFila = fila < 3;
        }
        return;
    }
}
