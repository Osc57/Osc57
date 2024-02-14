notes_list = []

for i in range(5):
    note = float(input("Dime la nota que has sacado: "))

    if note < 0 or note > 10:
        print("No se puede")
    else:
        notes_list.append(note)

half = sum(notes_list)/len(notes_list)
maximum = max(notes_list)
minimum = min(notes_list)

print(f'Tus notas son: {notes_list}')
print(f'Tu nota maxima es: {maximum}')
print(f'Tu nota minima es: {minimum}')
print(f'Tu media es: {half}')