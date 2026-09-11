def suma_recursiva(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return n + suma_recursiva(n-1)


n1 = int(input("Dime un número: "))
numero = suma_recursiva(n1)

print(f'La suma de los primeros {n1} números es: {numero}')