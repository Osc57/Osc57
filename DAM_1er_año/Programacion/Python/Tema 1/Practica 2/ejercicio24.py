cantidad=int(input("Cantidad números que quieres poner en la media: "))

media = 0
cuenta = cantidad

while cuenta >0:
    n = int(input(f"Números restantes: {cuenta} nuevo número: "))
    cuenta -=1
    media = media + n

media = media/cantidad
print(f"La media es: {media}")