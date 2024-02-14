def combinar_listas_ordenadas(l1, l2):
    lista = l1.copy()

    for elemento in l2:
        if elemento not in lista:
            lista.append(elemento)
    lista.sort()
    return lista


lista1 = [2, 3, 8, 9, 58, 200]
lista2 = [3, 8, 25, 120, 200, 300]

print(combinar_listas_ordenadas(lista1, lista2))