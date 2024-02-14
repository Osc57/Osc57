def combinar_listas_ordenadas(l1, l2):
    lista_temporal = set(l1 + l2)
    lista3 = sorted(lista_temporal)
    return lista3


lista1 = [2, 3, 8, 9, 58, 200]
lista2 = [3, 8, 25, 120, 200, 300]


lista_sin_duplicados = combinar_listas_ordenadas(lista1, lista2)
print(lista_sin_duplicados)