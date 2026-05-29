# Código generado desde EBDA

n = 10
a = 0
b = 1
i = 0
temp = 0
corriendo = True
print("Serie Fibonacci de 10 terminos:")
print(a)
print(b)
while corriendo:
    temp = a + b
    print(temp)
    a = b
    b = temp
    i += 1
    corriendo = i < n
print('Resultado final: ' + str(b))
