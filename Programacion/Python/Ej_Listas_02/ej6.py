list_number_subject = ["Matematicas", "Fisica", "Quimica", "Historia", "Lengua"]

passed = []

for asignatura in list_number_subject:
    note = float(input("Que nota has sacado en " + asignatura + ": "))
    if note >= 5:
        passed.append(asignatura)

for asignatura in passed:
    list_number_subject.remove(asignatura)
print("Tienes que repetir" + str(list_number_subject))
