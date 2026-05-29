// Código generado desde EBDA
#include <iostream>
#include <string>

using namespace std;

int main() {
    int vida = 100;
    int nivel = 1;
    int contador = 0;
    string nombre = "Jugador1";
    string mensaje = "Hola";
    bool activo = true;
    bool vivo = true;
    cout << nombre << endl;
    cout << vida << endl;
    cout << activo << endl;
    vida = 90;
    nombre = "HeroX";
    activo = false;
    cout << vida << endl;
    cout << nombre << endl;
    cout << activo << endl;
    vida++;
    cout << vida << endl;
    vida--;
    vida--;
    cout << vida << endl;
    int suma = vida + nivel;
    int resta = vida - 10;
    int producto = nivel * 5;
    int division = vida / 3;
    cout << suma << endl;
    cout << resta << endl;
    cout << producto << endl;
    cout << division << endl;
    bool esMayor = vida > 50;
    bool esIgual = nivel == 1;
    bool esMenor = nivel < 10;
    cout << esMayor << endl;
    cout << esIgual << endl;
    cout << esMenor << endl;
    bool noActivo = !activo;
    cout << noActivo << endl;
    string saludo = "Hola, " + nombre;
    cout << saludo << endl;
    if (esMayor) {
        cout << "vida mayor a 50" << endl;
        nivel++;
    }
    if (activo) {
        cout << "jugador activo" << endl;
    } else {
        cout << "jugador inactivo" << endl;
    }
    if (esMayor) {
        cout << "vida > 50, revisando nivel..." << endl;
        if (esIgual) {
            cout << "nivel = 1 confirmado" << endl;
        } else {
            cout << "nivel distinto de 1" << endl;
        }
    }
    while (esMenor) {
        cout << contador << endl;
        contador++;
        nivel++;
        esMenor = nivel < 5;
    }
    if (esMayor) {
        cout << "entrando al respawn dentro de rush" << endl;
        int i = 0;
        bool seguir = true;
        while (seguir) {
            i++;
            cout << i << endl;
            seguir = i < 3;
        }
    }
    int x = 0;
    bool corriendo = true;
    while (corriendo) {
        x++;
        if (esMayor) {
            cout << "x subiendo, vida sigue alta" << endl;
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
            cout << col << endl;
            loopCol = col < 3;
        }
        loopFila = fila < 3;
    }
    return vida;
    return 0;
}
