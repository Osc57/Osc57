import random
lista = []

for indice in range(1, 11):
    lista.append(random.randint(1, 10))
# Ordeno la lista
lista.sort()

# Recorro el vector ordenado
for i in lista:
    print(i, " ", end="")