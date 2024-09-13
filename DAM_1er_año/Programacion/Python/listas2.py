#shoppinglist = ["Agua", "Huevos", "Vinagre", '...', 'Mermelamda'] #Las listas empiezan en 0
#shoppingCena = ["Ensalada","Pizza","Postre"]

#Saber si un elemento esta dentro de la lista
#print('Pollo' in shoppinglist)
#print('Agua' in shoppinglist)

'''Ejercicio:
Determine si una cadena de texto dada en un isograma, es decir, no se repite ninguna letra
Ejemplos validos de isogramas:
• lumberjacks
• background
• downstream
• six-years-old'''
letras_analizadas = []
palabra = "lumberjack"

for letter in palabra:
    if letter in letras_analizadas:
        print("No es un isograma")
        break
    letras_analizadas.append(letter)
else:
    print("Es un isograma")










#Buscar elementos
#print(shoppinglist.index('Huevos'))


#Borrar elementos lista
#del shoppinglist[3]
#print(shoppinglist)
#shoppinglist.remove('...')
#producto_borrado = shoppinglist.pop(3)
#shoppinglist[1:4] = []
#print(shoppinglist)
#print(producto_borrado)


#print(shoppinglist[1:4] = {'Atún', 'patatas bravas', 'cocacola'})
#print(shoppinglist[1:4])

#Cambiar un elemento
#shoppinglist[0] = 'Cerveza'
#print(shoppinglist)


#lista_de_la_compra = shoppinglist + shoppingCena

#shoppinglist = shoppinglist + shoppingCena

#shoppinglist += shoppingCena
#shoppinglist.extend(shoppingCena)

#shoppinglist.extend('Limon')

#shoppinglist.append(shoppingCena)


#shoppinglist.append("Queso")
#shoppinglist.insert(len(shoppinglist), "Jamon")
#print(shoppinglist)

#shoppinglist.insert(-100,'Jamón')
#shoppinglist.insert(99,'Queso')
#print(shoppinglist)

#print(shoppinglist[1])
#print(shoppinglist[0])
#print(shoppinglist[2])

#print(shoppinglist[-1])

#cadena = "Hola que tal?"
#Solo quiero imprimir que de esa cadena
#print(cadena[5:8])
#print(shoppinglist[1:3])

#print(shoppinglist)
#shoppinglist.reverse()
#print(shoppinglist)

#Añadir elemenos a la lista:
#shoppinglist.append("Pepinillos")
#print(shoppinglist)

## crea una lista con los multiplos de 3 desde 0 hasta 250
#imprime la lista.

#lista_rangos = list(range(0, 251, 3))
#print(lista_rangos)






