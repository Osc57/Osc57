def es_primo(num):
    for n in range(2, num):
        if num % n == 0:
            return "No es primo"
    return "Es primo"

n1 = int(input("Dime un número para saber si es primo o no: "))

primo = es_primo(n1)

print(f'El número que has introducido: {primo}')
