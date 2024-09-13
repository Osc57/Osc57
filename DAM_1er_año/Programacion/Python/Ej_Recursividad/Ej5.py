def es_primo(n,d=2):
    if n <= 1:
        return False
    elif n == 2:
        return True
    elif n % d == 0:
        return False
    elif d * d > n:
        return True
    return es_primo(n, d + 1)


n1 = int(input("Dime tu número: "))

resultado = es_primo(n1)
print("Tu número es:" , resultado)