import random

intentos = 0
numero = random.randint(1,100)
print("Jugemos a adivinar el número aleatorio")

while True:
    adivina = float(input("Dime el número: "))
    intentos = intentos+1
    if adivina < numero:
        print("El número es muy bajo")
    if adivina > numero:
        print("El número es muy alto")
    if adivina == numero:
        print("ENHORABUNEA HAS ACERTADO EL NÚMERO EN " + str(intentos) + " INTENTOS")
        break


