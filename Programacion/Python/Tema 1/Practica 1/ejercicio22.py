v1= int(input("Dime un valor para una variable (v1): "))
v2= int(input("Dime otro valor para otra variable (v2): "))
print("Intercambiando los valores...")

import time     #Esto lo que hace es atrasar la salida del código
time.sleep(3)
variable_aux=v1
v1, v2 = v2, v1

print("Ahora el valor de v1 es: " + str(v1))
print("Ahora el valor de v2 es: " + str(v2))
