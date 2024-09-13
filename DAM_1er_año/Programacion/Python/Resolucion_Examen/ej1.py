lista = ['Antonio', 'Juan', 'Juan', 'Pedro', 'Lucas', 'Ana', 'Juliana', 'Ana', 'Juan', 'Ana', 'Ana', 'Lucia', 'Pablo']

print(f'La lista sin modificar: {lista}')

for i in range(len(lista)-1, -1, -1):
    nombre_actual = lista[i]
    cont = 0
    for j in range(len(lista)-1, -1, -1):
        if lista[j] == nombre_actual:
            cont += 1
        if lista[j] == nombre_actual and cont > 2:
            del lista[j]

print(f'Lista modificada: {lista}')