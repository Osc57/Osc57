def elevar_numero (base, exponente):
    resultado = 1
    for i in range (0, exponente):
        resultado = resultado * base
    return resultado

num1 = int(input("Dime un número: "))
num2 = int(input("Dime el número para elevar: "))

print(f'Tu elvación es: {elevar_numero(num1,num2)}')