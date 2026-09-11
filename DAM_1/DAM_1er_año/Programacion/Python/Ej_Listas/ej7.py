words_number = int(input("Dime cuántas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la palabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')

no_repetition_list = []

for i in list_number_word:
    if i not in no_repetition_list:
        no_repetition_list.append(i)


print(f'La lista si repeticiones es: {no_repetition_list}')