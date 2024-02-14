print("Hola vamos a jugar a Akinator de Marvel, piensate un personaje")
si=("si")
no=("no")

volar=input("¿Tu personaje puede volar?: ")
if volar == si:
    humano=(input("¿Tu personaje es humano?: "))
    if humano == si:
        mascara=(input("¿Tu personaje tiene máscara?: "))
        if mascara == si:
            print("Tu personaje es: Ironman")
        else:
            if mascara == no:
                print("Tu personaje es: Capitan America")
    else:
        if humano==no:
           mascara=(input("¿Tu personaje tiene máscara?: ")) 
        if mascara == no:
            print("Tu personaje es: Visión")
        else:
            if mascara == si:
                print("Tu personaje es: Ronan Accuser")
else:
    if volar==no:
        humano=(input("¿Tu personaje es humano?: "))
        if humano==no:
            mascara=(input("¿Tu personaje tiene máscara?: "))
            if mascara==no:
                print("Tu personaje es: Thanos")
            else:
                if mascara==si:
                    print("Tu personaje es: Black Bolt")
        else:
            if humano == si:
                 mascara=(input("¿Tu personaje tiene máscara?: "))
                 if mascara== si:
                    print("Tu personaje es: Spiderman")
                 else:
                     mascara==no
                     print("Tu personaje es: Hulk")
                    
                
        