# Código generado desde EBDA

a = 48
b = 18
temp = 0
corriendo = True
print("MCD de 48 y 18:")
while corriendo:
    if b == 0:
        corriendo = False
    else:
        temp = b
        b = a / b
        b = b * temp
        b = a - b
        a = temp
        corriendo = b > 0
print(a)
print('Resultado final: ' + str(a))
