words_number = int(input("Dime cuantas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la plabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')

delete_word = input("Que palabra quieres eliminar: ")

list_number_word.remove(delete_word)

print(f'La lista ahora es: {list_number_word}')