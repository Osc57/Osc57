print("Escribe 'salir' para salir")

while True:
        texto = input("Escribe: ")
        if texto.lower() == "salir":
            print("Programa terminado")
            break
        print(f"Eco: {texto}")