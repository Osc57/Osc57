words_number = int(input("Dime cuántas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la palabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')

list_number_word.reverse()
print(f'La lista inversa es: {list_number_word}')