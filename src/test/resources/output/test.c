// Código generado desde EBDA
#include <stdio.h>
#include <string.h>

int main() {
    int vida = 100;
    int nivel = 1;
    int contador = 0;
    char nombre[256] = "Jugador1";
    char mensaje[256] = "Hola";
    int activo = 1;
    int vivo = 1;
    printf("%s\n", nombre);
    printf("%d\n", vida);
    printf("%d\n", activo);
    vida = 90;
    strcpy(nombre, "HeroX");
    activo = 0;
    printf("%d\n", vida);
    printf("%s\n", nombre);
    printf("%d\n", activo);
    vida++;
    printf("%d\n", vida);
    vida--;
    vida--;
    printf("%d\n", vida);
    int suma = vida + nivel;
    int resta = vida - 10;
    int producto = nivel * 5;
    int division = vida / 3;
    printf("%d\n", suma);
    printf("%d\n", resta);
    printf("%d\n", producto);
    printf("%d\n", division);
    int esMayor = vida > 50;
    int esIgual = nivel == 1;
    int esMenor = nivel < 10;
    printf("%d\n", esMayor);
    printf("%d\n", esIgual);
    printf("%d\n", esMenor);
    int noActivo = !activo;
    printf("%d\n", noActivo);
    char saludo[256] = "Hola, ";
    strcat(saludo, nombre);
    printf("%s\n", saludo);
    if (esMayor) {
        printf("%s\n", "vida mayor a 50");
        nivel++;
    }
    if (activo) {
        printf("%s\n", "jugador activo");
    } else {
        printf("%s\n", "jugador inactivo");
    }
    if (esMayor) {
        printf("%s\n", "vida > 50, revisando nivel...");
        if (esIgual) {
            printf("%s\n", "nivel = 1 confirmado");
        } else {
            printf("%s\n", "nivel distinto de 1");
        }
    }
    while (esMenor) {
        printf("%d\n", contador);
        contador++;
        nivel++;
        esMenor = nivel < 5;
    }
    if (esMayor) {
        printf("%s\n", "entrando al respawn dentro de rush");
        int i = 0;
        int seguir = 1;
        while (seguir) {
            i++;
            printf("%d\n", i);
            seguir = i < 3;
        }
    }
    int x = 0;
    int corriendo = 1;
    while (corriendo) {
        x++;
        if (esMayor) {
            printf("%s\n", "x subiendo, vida sigue alta");
        }
        corriendo = x < 4;
    }
    int fila = 0;
    int loopFila = 1;
    while (loopFila) {
        fila++;
        int col = 0;
        int loopCol = 1;
        while (loopCol) {
            col++;
            printf("%d\n", col);
            loopCol = col < 3;
        }
        loopFila = fila < 3;
    }
    return vida;
    return 0;
}
