words_number = int(input("Dime cuántas palabras tiene la lista: "))

list_number_word = []
if words_number <= 0:
    print("¡ Imposible !")
else:
    for i in range(words_number):
        word = input(f'Dime la palabra {i + 1}: ')
        list_number_word.append(word)

print(f'La primera lista de palabras es: {list_number_word}')

second_words_number = int(input("Dime cuántas palabras tiene la primera lista: "))

second_list_number_word = []

for i in range(second_words_number):
    second_word = input(f'Dime la palabra {i + 1}: ')
    second_list_number_word.append(second_word)

print(f'La segunda lista de palabras es: {second_list_number_word}')

both_list = []
in_list1_no_list2 = []
in_list2_no_list1 = []
all_words = []

for i in list_number_word:
    if i in second_list_number_word:
        both_list.append(i)
    else:
        in_list1_no_list2.append(i)
    all_words.append(i)

for x in second_list_number_word:
    if x not in list_number_word:
        in_list2_no_list1.append(x)
    all_words.append(x)

all_words = list(set(all_words))

print(f'Palabras que aparecen en las dos listas: {both_list}')
print(f'Palabras que solo aparecen en la primera lista: {in_list1_no_list2}')
print(f'Palabras que solo aparecen en la segunda lista: {in_list2_no_list1}')
print(f'Todas las palabras: {all_words}')


