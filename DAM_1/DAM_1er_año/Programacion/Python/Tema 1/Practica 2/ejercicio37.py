import random
ordenador = random.randint(1, 100)

for i in range (5):
    apuesta = int(input("Introduce tu apuesta: "))
    if ordenador == apuesta:
        print ("Enhora buena, acertaste")
        break
    else:
        seguir = input("Fallaste, quieres continuar y/n: ")
        if ordenador < apuesta:
            print("El número introducido es mayor al pensado por el PC")
        else:
            print("El número introducido es menor al pensado por el PC")
        if seguir == 'n' or seguir == 'N':
            break