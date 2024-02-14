def ackermann(m, n):
    if m == 0:
        return n+1
    elif m>0 and n == 0:
        return ackermann(m - 1, 1)
    else:
        return ackermann(m - 1, ackermann(m, n-1))

n1 = int(input("Ackermann, dime un número(1-3): "))
n2 = int(input("Ackermann, dime otro número (1-6): "))
print("Tu número ackerman es: ", ackermann(n1, n2))