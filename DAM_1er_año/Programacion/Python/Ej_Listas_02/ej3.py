list_number_subject = ["Matematicas", "Fisica", "Quimica", "Historia", "Lengua"]

notes = []

for asignatura in list_number_subject:
    note = float(input("Que nota has sacado en " + asignatura + ": "))
    notes.append(note)

for i in range(len(list_number_subject)):
    print("En " + asignatura + " has sacado un: " + str(notes))