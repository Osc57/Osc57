import random

lista = []
lista_veces = []
for _ in range(30):
    numero = random.randint(0, 49)
    lista.append(numero)

for numero in lista:
    cont = 0
    for i in lista:
        if i == numero:
            cont += 1

    lista_veces.append(cont)

mayor = max(lista_veces)
indice = lista_veces.index(mayor)
print(f'{mayor}    {lista[indice]}')

