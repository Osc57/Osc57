n1 = int(input("Numero: "))
n2 = int(input("Numero: "))
n3 = int(input("Numero: "))

nota = (n1 + n2 + n3)/3

if nota <5:
    print("Suspenso")
if nota >=5 or nota <6:
    print("Aprobado")
if nota >=6 or nota <7:
    print("Bien")
if nota >=7 or nota <9:
    print("Notable")
if nota == 9 or nota == 10:
    print("Sobresaliente")
