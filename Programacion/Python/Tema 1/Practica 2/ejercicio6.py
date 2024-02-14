n1=int(input("Dime un número para hacer la raiz cuadrada: "))

raiz=n1**0.5

if raiz<0:
    print("La raíz no es posible")
else:
    print("El resultado de tu raíz es: " + str(raiz))