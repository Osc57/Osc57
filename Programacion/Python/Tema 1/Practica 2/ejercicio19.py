turno=input("¿Que turno tienes en el trabajo?: ")
semana=input("¿Que día de la semana es tu turno?: ")
diurno=("diurno")
nocturno=("nocturno")

domingo=("domingo")
tarifa_d=(20*8)
tarifa_n=(35*8)

if turno == diurno:
    print("Al ser tu turno diurno tu tarifa es: " + str(tarifa_d)+ "€")
    if semana == domingo:
        print("Al ser domingo tu tarifa aumenta 10€: " + str(tarifa_d+10)+ "€")
else:
    if turno == nocturno:
        print("Al ser tu turno nocturno tu tarifa es: " + str(tarifa_n)+ "€")
        if semana == domingo:
            print("Al ser domingo tu tarifa aumenta 15€: " + str(tarifa_n+15)+ "€")
       

