num1= int(input("Dime un número entero: "))
num2= int(input("Dime otro número entero: "))

mayor = max(num1, num2)
menor = min(num1, num2)
multiplo = (mayor%menor == 0) #Esto según JuanMa es una basura

print("El numero mayor es:" , mayor)
print("El numero menor es:" , menor)
print("El multiplo es:" , multiplo)
