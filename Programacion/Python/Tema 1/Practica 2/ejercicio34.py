import random 

for i in range(1,16):
    apuesta = random.randint(1,3)
    if apuesta == 1:
        resultado ='1'
    if apuesta == 2:
        resultado ='2'
    if apuesta == 3:
        resultado ='X'
    print('Partido '+ str(i)+' - El resultado del partido es: '+ resultado)
