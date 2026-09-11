def is_primo(num):
    for n in range(2, num):
        if num % n == 0:
            return "no es primo"
    return "es primo"

n1 = int(input("Dime un número y te dire si es primo o no: "))
primo = is_primo(n1)

print(f'El número {n1} {primo}')