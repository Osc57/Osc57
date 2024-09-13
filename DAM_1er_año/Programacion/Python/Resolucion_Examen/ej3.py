def genera_primos():
    lista_primos = []
    for i in range(2, 2000):
        primo = True
        for j in range(2, i):
            if i % j == 0:
                primo = False
                break
        if primo:
            lista_primos.append(i)
    return lista_primos


numero = int(input("Introduce un número: "))
numeros_primos = genera_primos()

for x in range(2000):
    if numero < numeros_primos[x]:
        print(numeros_primos[x])
        break



