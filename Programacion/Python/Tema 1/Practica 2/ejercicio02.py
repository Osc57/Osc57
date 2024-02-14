lado_largo= int(input("Dime el lado largo de tu rectangulo: "))
lado_corto= int(input("Dime el lado corto de tu rectangulo: "))

superficie= lado_largo*lado_corto
perimetro= lado_corto*2 + lado_largo*2

print("La superficie de tu rectángulo es: " + str(superficie))
print("El perimetro de tu rectángulo es: " + str(perimetro))
