
print("Esto es un conversor de grados Centigrados a grados Farenheit")
grados=float(input("Introduceme los grados: "))
grados1=input("Lo quieres en grados Celsius o Farenheit: ")

fare=(grados*9/5)+32

variable_save=fare

cel=(fare-32)*5/9

if grados1== "farenheit" or grados1=="Farenheit":
    print("Tus grados en farenheit son: " + str(variable_save)+"ºF")
elif grados1== "celsius" or grados1== "Celsius":
    print("Tus grados en celsius son: " + str(cel)+"ºC")
else:
    print("No puedo procesar datos")

