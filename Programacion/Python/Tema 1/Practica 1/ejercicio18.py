num1= float(input("Dime un número: "))
num2= float(input("Dime otro número: "))

cociente= num1/num2
cociente=cociente * 1000
cocienteEntero= int(cociente)
cocienteConDecimales= float(cocienteEntero/1000)

print("Tu cociente es:" , cocienteConDecimales)

#print(f"El cociente de {num1} y {num2} es: {cociente:.3f}")