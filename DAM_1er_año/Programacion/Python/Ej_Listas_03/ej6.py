dias = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
month_name = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"]
while True:
    month = int(input("Introduce un mes (1-12): "))
    if month < 1 or month > 12:
        print("Error: mes incorrecto.")

    if month >= 1 and month <= 12: break
print("El mes de", month_name[month-1], "tiene", dias[month-1],"días.")