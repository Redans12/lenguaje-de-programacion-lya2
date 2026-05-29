# Código generado desde EBDA

n = 20
i = 2
buscando = True
print("Numeros primos hasta 20:")
while buscando:
    divisor = 2
    esPrimo = 1
    revisando = True
    while revisando:
        modulo = i / divisor
        modulo = modulo * divisor
        if modulo == i:
            esPrimo = 0
        divisor += 1
        revisando = divisor < i
    if esPrimo == 1:
        print(i)
    i += 1
    buscando = i < n
print('Resultado final: ' + str(i))
