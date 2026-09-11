print("Voy a pedirte que me des una hora, unos muinutos y unos segundos para que le sume un segundo")
horas=int(input("Dime la hora que tu quieras: "))
minutos=int(input("Dime los minutos que quieras: "))
segundos= int(input("Dime los segundos que quieras: "))

if segundos >=60:
    minutos=(segundos//60)+minutos
    segundos=segundos%segundos
if minutos >=60:
    horas=(minutos//60)+horas
    minutos=minutos%minutos
if horas >=24:
    horas=horas//horas
    horas== 0

print("Estas son tus horas: " +str(horas))
print("Estos son tus minutos: " +str(minutos))
print("Estos son tus segundos: " +str(segundos))
