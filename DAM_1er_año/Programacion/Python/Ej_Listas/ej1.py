
words_number = int(input("Dime cuantas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la plabra {i + 1}: ')
    list_number_word.append(word)

if words_number <= 0:
    print("¡ Imposible !")
else:
    print(f'La lista de palabras es: {list_number_word}')
