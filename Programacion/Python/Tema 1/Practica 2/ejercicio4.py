piedra=("piedra")
papel=("papel")
tijera=("tijera")
print("Jugemos al piedra, papel o tijera")
print("Necesito dos jugadores, llama a tu amigo")

j1=(input("Dime tu nombre jugador 1: "))
j2=(input("Dime tu nombre jugador 2: "))
print("Okay, ahora necesito que ambos selecciones que quereis jugar")

v1=input("Para ello necesito que " + j1 + " diga que va a jugar (piedra, papel o tijera): ")
v2=input("Para ello necesito que " + j2 + " diga que va a jugar (piedra, papel o tijera): ")

if v1==v2:
    print("Habeis empatado")
elif v1 == papel and v2 == piedra:
    print("El ganador es: ", j1)
elif v1 == piedra and v2 == papel:
    print("El ganador es: ", j2)
elif v1 == tijera and v2 == piedra:
    print("El ganador es: ", j2)
elif v1 == piedra and v2 == tijera:
    print("El ganador es: ", j1)
elif v1 == papel and v2 == tijera:
    print("El ganador es: ", j2)
elif v1 == tijera and v2 == papel:
    print("El ganador es: ", j1)
else:
    print("Metiste mal un dato")
