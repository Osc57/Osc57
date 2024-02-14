words_number = int(input("Dime cuantas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la plabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')

replaced_word = input("Que palabra de la lista quieres sustituir: ")

word_replaced = input("Por que palabra quieres sustituirla: ")

for i in range(len(list_number_word)):
    if list_number_word[i] == replaced_word:
        list_number_word[i] = word_replaced

print(f'La lista es ahora: {list_number_word}')


