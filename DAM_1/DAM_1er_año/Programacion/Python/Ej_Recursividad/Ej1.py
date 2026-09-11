def suma_numeros(n):
    if n <= 0:
        return 0
    else:
        return n + suma_numeros(n-1)

print("Dime un número para hacer una recursiva que sume todos los números enteros positivos desde 1 hasta un número N dado.")
n1 = int(input("Dime el número: "))

print(f'La suma recursiva de {n1} es: {suma_numeros(n1)}')