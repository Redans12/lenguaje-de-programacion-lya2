# Código generado desde EBDA

n = 10
suma = 0
i = 1
corriendo = True
print("Sumatoria de 1 a 10:")
while corriendo:
    suma = suma + i
    i += 1
    corriendo = i < n
suma = suma + n
print(suma)
print('Resultado final: ' + str(suma))
