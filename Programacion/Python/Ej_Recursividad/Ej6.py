def fibonacci(m):
    if m <= 0:
        return 0
    elif m == 1:
        return 1
    else:
        return fibonacci(m-1) + fibonacci(m-2)

def suma_fibonacci(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibonacci(n) + suma_fibonacci(n-1)

n1 = int(input("Fibonacci dime un número: "))
print("Tu fibonacci: ", suma_fibonacci(n1))