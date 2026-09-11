def cadena_texto(texto):

    ALPHABET = "abcdefghijklmnopqrstuvwxyz"
    for letter in texto:
        if letter in ALPHABET:
           print("Tu frase esta correcta")
        else:
            print("Tu frase tiene caracteres no alfabeticos")
        break


frase = input("Dime una frase: ")

siono = cadena_texto(frase)

