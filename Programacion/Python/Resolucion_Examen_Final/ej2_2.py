def combinar_listas_ordenadas(l1, l2):
    lista = l1 + l2
    lista.sort()
    lista_sin_dobles = []
    for elemento in lista:
        if elemento not in lista_sin_dobles:
            lista_sin_dobles.append(elemento)
    return lista_sin_dobles


lista1 = [2, 3, 8, 9, 58, 200]
lista2 = [3, 8, 25, 120, 200, 300]

print(combinar_listas_ordenadas(lista1, lista2))


