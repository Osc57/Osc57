import random


class Numero_veces:
    numero = int
    veces = int

    def __init__(self, numero):
        self.numero = numero
        self.veces = 1


def esta_en_la_lista(lista, numero):
    for number in lista:
        if number.numero == numero.numero:
            return True
    return False


def sumar_uno_al_numero(lista, numero):
    for number in lista:
        if number.numero == numero.numero:
            number.veces += 1


lista = []
for _ in range(30):
    numero_aleatorio = random.randint(0, 49)
    numero = Numero_veces(numero_aleatorio)
    if esta_en_la_lista(lista, numero):
        sumar_uno_al_numero(lista, numero)
    else:
        lista.append(numero)

for elemento in lista:
    print(f'El numero {elemento.numero} aparece {elemento.veces} veces')