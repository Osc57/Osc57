def cuantos_digitos(n):
    i = 1
    while n > 9:
        n = n / 10
        i = i + 1
    return i

n1 = int(input("Dime un número para que yo cuente sus digitos: "))

print(f'Tu número tiene {cuantos_digitos(n1)} cifras')