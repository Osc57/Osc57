a = (1, 2, 3)
b = (-1, 0, 2)

product = 0
for i in range(len(a)):
    product += a[i]*b[i]
print("El producto es " + str(product))