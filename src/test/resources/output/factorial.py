# Código generado desde EBDA

n = 5
resultado = 1
i = 1
corriendo = True
while corriendo:
    resultado = resultado * i
    i += 1
    corriendo = i < n
resultado = resultado * n
print("Factorial de 5:")
print(resultado)
print('Resultado final: ' + str(resultado))
