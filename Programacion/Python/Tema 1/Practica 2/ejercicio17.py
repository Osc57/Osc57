import math

a=float(input("Dime un número para una ecuación de segundo grado: "))
b=float(input("Dime el segundo número: "))
c=float(input("Dime el tercer número: "))

discriminante= b**2 - 4*a*c

if discriminante >0:
    x1 =(-b + math.sqrt(discriminante)/(2*a))
    x2 =(-b - math.sqrt(discriminante)/(2*a))
    print("Tiene dos soluciones:")
    print("La primera solución es: " + str(x1))
    print("La segunda solución es: " + str(x2))
elif discriminante > 0:
    x1= -b/(2*a)
    print("Tiene una unica solución:")
    print("La solución es: " + str(x1))
else:
    print("No tiene solución")
    