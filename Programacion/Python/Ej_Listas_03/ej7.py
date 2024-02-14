list_1 = []
list_2 = []
list_3 = []
for index in range(1, 6):
    list_1.append(int(input("Introduce el elemento %d del vector 1: " % index)))
for index in range(1, 6):
    list_2.append(int(input("Introduce el elemento %d del vector 2: " % index)))

for index in range(0, 5):
    list_3.append(list_1[index] + list_2[index])

print("La suma de los vectores es: ")
for i in list_3:
    print(i, " ", end="")