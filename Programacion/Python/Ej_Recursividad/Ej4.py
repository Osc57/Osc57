def suma_factoriales(n):
    if n == 0:
        return 0
    else:
        return factorial(n) + suma_factoriales(n-1)
def factorial(m):
    if m == 0:
        return 1
    else:
        return m * factorial(m-1)

n1 = int(input("Dime un número: "))
resultado = suma_factoriales(n1)
print(f'Resultado factorial: {resultado}')

