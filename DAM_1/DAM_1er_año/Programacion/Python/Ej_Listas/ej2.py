words_number = int(input("Dime cuantas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la plabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')


search = input("Dime la palabra que quieres buscar: ")

count_word = list_number_word.count(search)

print(f'La palabra {search} sale {count_word} veces')