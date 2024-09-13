n1= int(input("Dime un número para hacer el mcd: "))
n2= int(input("Dime otro número para hacer el mcd: "))


if n1 <n2:
    _min = n1
else:
    _min = n2

for divisor in range (_min, 0, -1):
    if n1 % divisor == 0 and n2 % divisor == 0:
        mcd = divisor
        break
    else:
        mcd = 1
print("El mcd de tus números es: " + str (mcd))