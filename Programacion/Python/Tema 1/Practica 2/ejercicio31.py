n = int(input("Número para comprobar: "))
i = 2

while i <= int((n ** 0.5)+1):

    if (n % i) == 0:
        print(f"{n} no es primo")
        i = 0
        break
    i += 1
if i>0: print("Es primo")