word = input("Dame una palabra: ")

vocals = ['a', 'e', 'i', 'o', 'u']

for vocal in vocals:
    veces = 0
    for letra in word:
        if letra == vocal:
            veces += 1
    print("La vocal " + vocal + " aparece " + str(veces) + "veces")
