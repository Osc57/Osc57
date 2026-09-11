segundost = 9500
horas = segundost // 3600  
segundost %= 3600
minutos = segundost // 60  
segundost %= 60
print(f"Horas: {horas}, Minutos: {minutos}, Segundos: {segundost}")