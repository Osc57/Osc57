def contar_vocales(vocales):
    voc = 0
    for letter in vocales:
        if letter in "aeiouAEIOU":
            voc = voc + 1
    return voc

frase =input("Dime una palabra para sacar las vocales que contiene: ")

numeroletras = contar_vocales(frase)

print("Tu palabra: " + str(frase) + ", tiene: " + str(numeroletras) + " vocales")

