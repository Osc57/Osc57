def numeros_mayores(mayor, menor):
    if mayor > menor:
        return mayor
    return menor



n1 = int(input("Dime un número: "))
n2 = int(input("Dime otro número: "))

print(f'El número mayor es {numeros_mayores(n1,n2)}')

