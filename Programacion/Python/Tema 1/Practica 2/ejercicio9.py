n1=int(input("Dame un número: "))
n2=int(input("Dame otro número: "))

resta=n1-n2

if n1>n2:
    print("El primer número es mayor y la resta es: " + str(resta))
else:
    print("La resta es: " + str(resta) + " y el primer número no es mayor" )