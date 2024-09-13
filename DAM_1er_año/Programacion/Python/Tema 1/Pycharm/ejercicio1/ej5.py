
while True:
    name = input("Digame su nombre: ")
    frase = name.istitle()
    if frase:
        print("Hola: " + str(name) + ", Escribiste tu nombre bien")
        break
    else:
        print("Error. Debe escribirlo correctamente")
