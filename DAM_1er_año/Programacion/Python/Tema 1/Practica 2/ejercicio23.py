print ("Programa que calcula el factorial")
numero = int(input("Introduzca el número: "))
factorial = 1
i = 1
while (i <= numero):
    factorial = factorial * i
    i = i + 1
print ("El factorial de " + str(numero) + " es " + str(factorial))