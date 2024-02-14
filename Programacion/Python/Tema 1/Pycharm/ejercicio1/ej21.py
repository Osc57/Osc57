def factorial(n):
    if n == 1 or n == 0:
        return 1
    else:
        return n * factorial(n-1)

fact = int(input("Dime un número al cual le quieras sacar el factorial: "))

print(f'Tu factorial: {factorial(fact)}')