import random

contador_aciertos = 0
for i in range(1,16):
    opciones = "1X2"
    apuesta = random.choice(opciones)
    sorteo = random.choice(opciones)

    if apuesta != sorteo:
        print(f'Mi apuesta: {apuesta} y el sorteo: {sorteo} -> NO ACIERTAS')
    else:
        print(f'Mi apuesta: {apuesta} y el sorteo: {sorteo} -> ACIERTAS')
        contador_aciertos +=1
print("El número de aciertos fue: " , contador_aciertos)