dividendo=int(input("Dame un número para hacer de dividendo: "))
divisor=int(input("Dime otro número para hacer de divisor: "))

cociente=dividendo/divisor
resto=dividendo%divisor

if resto<cociente:
    print("Tu cociente es: " + str(cociente) + " y el resto es: " + str(resto))
else:
    print("Tu cociente es: " + str(cociente) + " y el resto es: " + str(resto))

#Este ej esta incompleto