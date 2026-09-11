distancia=int(input("Dime la distancia en KM: "))
estancia=int(input("Cuantos días de estancia: "))
precio_km= distancia*2.5

if distancia>=800 and estancia>=7:
    precio_km = precio_km - (precio_km * 0.30)
    print("Descuento del 30%")
print("Importe: " + str(precio_km))