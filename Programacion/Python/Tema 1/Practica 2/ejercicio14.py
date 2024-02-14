n1=int(input("Dime un número: "))

num_str= str(n1)
num_cifras= len(num_str)

if num_cifras <=5:
    print( str(n1) + " tiene " + str(num_cifras)+ " cifras")
else:
    print("El número que has puesto no es valido")