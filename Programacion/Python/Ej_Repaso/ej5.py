
while True:
    name = input("Dime tu nombre: ")
    phrase = name.istitle()
    if phrase:
        print(f'Hola {name}')
        break
    else:
        print("Has escrito tu nombre mal, escribelo bien")
    