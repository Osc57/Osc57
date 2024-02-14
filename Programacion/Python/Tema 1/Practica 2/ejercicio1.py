num1 = int(input("Dime el primer número: "))
num2 = int(input("Dime el segundo número: "))
num3 = int(input("Dime el tercer número: "))

if num1 <= num2 and num1 <= num3:
    minimo = num1
elif num2 <= num1 and num2 <= num3:
    minimo = num2
else:
    minimo = num3

import time
time.sleep(1)
print("Metiste estos números " + str(num1)+", " + str(num2) +", "+ str(num3))
import time
time.sleep(3)
print("Y el número mínimo es: " + str(minimo))
