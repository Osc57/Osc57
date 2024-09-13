def potencia(b, e):
    if e == 0:
        return 1
    else:
        return b * potencia(b, e-1)

base = int(input("Dime un número que quieras elevar: "))
exponente = int(input("Dime el número al que lo quieras elevar: "))

print(f'La potencia de {base} elevado a {exponente} es: {potencia(base, exponente)}')