n1 = int(input("Dime un número: "))
n2 = int(input("Dime otro número: "))
n3 = int(input("Dime otro número: "))

if n1 < n2 and n1 < n3:
    print(f'El número menor es {n1}')
elif n1 > n2 and n2 < n3:
    print(f'El número menor es {n2}')
else:
    if n3 < n2 and n3 < n1:
        print(f'El número menor es {n3}')