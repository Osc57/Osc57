year=int(input("Dame un año para saber si es bisiesto o no: "))

if year % 4 == 0:
    resultado=year % 100
    if resultado:
        if year % 400:
            print("Tu año es bisiesto")
else:
    print("Tu año no es bisiesto")