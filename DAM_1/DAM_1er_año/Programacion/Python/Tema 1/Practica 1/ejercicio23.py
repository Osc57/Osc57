a=int(input("Dime un número para una variable (esta será la variable a): "))
b=int(input("Dime otro número para una variable (este será la variable b): "))

a = a+b
b = a-b
a = a-b
print("Ahora el valor a es: " + str(a))
print("Ahora el valor b es: " + str(b))