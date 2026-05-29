# Código generado desde EBDA

vida = 100
nivel = 1
contador = 0
nombre = "Jugador1"
mensaje = "Hola"
activo = True
vivo = True
print(nombre)
print(vida)
print(activo)
vida = 90
nombre = "HeroX"
activo = False
print(vida)
print(nombre)
print(activo)
vida += 1
print(vida)
vida -= 1
vida -= 1
print(vida)
suma = vida + nivel
resta = vida - 10
producto = nivel * 5
division = vida / 3
print(suma)
print(resta)
print(producto)
print(division)
esMayor = vida > 50
esIgual = nivel == 1
esMenor = nivel < 10
print(esMayor)
print(esIgual)
print(esMenor)
noActivo = not activo
print(noActivo)
saludo = "Hola, " + nombre
print(saludo)
if esMayor:
    print("vida mayor a 50")
    nivel += 1
if activo:
    print("jugador activo")
else:
    print("jugador inactivo")
if esMayor:
    print("vida > 50, revisando nivel...")
    if esIgual:
        print("nivel = 1 confirmado")
    else:
        print("nivel distinto de 1")
while esMenor:
    print(contador)
    contador += 1
    nivel += 1
    esMenor = nivel < 5
if esMayor:
    print("entrando al respawn dentro de rush")
    i = 0
    seguir = True
    while seguir:
        i += 1
        print(i)
        seguir = i < 3
x = 0
corriendo = True
while corriendo:
    x += 1
    if esMayor:
        print("x subiendo, vida sigue alta")
    corriendo = x < 4
fila = 0
loopFila = True
while loopFila:
    fila += 1
    col = 0
    loopCol = True
    while loopCol:
        col += 1
        print(col)
        loopCol = col < 3
    loopFila = fila < 3
print('Resultado final: ' + str(vida))
