nota = float(input("Dime una nota númerica: "))

if nota < 0:
    print("Tu número es negativo")
elif nota <5:
    print("Suspenso")
elif nota == 5 or nota == 6:
    print("Aprobado")
elif nota == 7 or nota == 8:
    print("Notable")
elif nota == 9 or nota == 10:
    print(("Sobresaliente"))
elif nota >10:
    print("Nota del 1 al 10")
else:
    print("Error en la base de datos")
