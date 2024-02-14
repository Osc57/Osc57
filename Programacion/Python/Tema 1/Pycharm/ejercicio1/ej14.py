def escribir_triangulo(l, a):
    for i in range(a, 0, -1):
        linea = l * 1
        print(linea)

letra = input("Dime la una letra: ")
anchura = int(input("Dime la anchura que quieres: "))

print(escribir_triangulo(letra, anchura))