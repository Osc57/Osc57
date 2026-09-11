n1=int(input("Dame un número: "))
n2=int(input("Dame otro número: "))
n3=int(input("Dame otro número: "))

mayor=max(n1, n2, n3)
menor=min(n1 , n2, n3)
mediano= n1+n2+n3-mayor-menor

print("El número mayor es: " + str(mayor))
print("El número menor es: " + str(menor))
print("El número mediano es: " + str(mediano))