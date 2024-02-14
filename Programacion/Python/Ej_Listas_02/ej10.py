price = [50, 75, 46, 22, 80, 65, 8,]

minimum = maximum = price[0]

for price in price:
    if price < minimum:
        minimum = price
    elif price > maximum:
        maximum = price
print("El minimo es: " + str(minimum))
print("El maximo es: " + str(maximum))