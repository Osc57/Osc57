words_number = int(input("Dime cuántas palabras tiene la lista: "))

list_number_word = []

for i in range(words_number):
    word = input(f'Dime la palabra {i + 1}: ')
    list_number_word.append(word)

print(f'La lista de palabras es: {list_number_word}')

delete_words_number = int(input("Dime cuántas palabras quieres eliminar de la lista: "))

delete_list_number_word = []

for i in range(delete_words_number):
    deleted_word = input(f'Dime la palabra {i + 1}: ')
    delete_list_number_word.append(deleted_word)

for x in delete_list_number_word:
    if x in list_number_word:
        list_number_word.remove(x)

print(f'La lista de palabras a eliminar es {delete_list_number_word}')
print(f'La lista es ahora: {list_number_word}')
