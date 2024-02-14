edad=int(input("Dime la edad que tienes: "))
peso=float(input("Ahora dime cuanto pesas: "))
pulso=int(input("Cuanto pulso tienes: "))
plaquetas=int(input("Ahora dime el número de tus plaquetas: "))

if edad >= 18 and edad <= 65:
    if peso >= 50:
        if pulso >= 50 and pulso <= 110:
            if plaquetas >= 150000:
                print("Apto para donar sangre")
            else:
                print("No eres apto para donar sangre")
        else:
            print("No eres apto para donar sangre")
    else:
        print("No eres apto para donar sangre")
else:
    print("No eres apto para donar sangre")

    
    