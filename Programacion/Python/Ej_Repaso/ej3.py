def count_vocals(vocals):
    voc = 0
    for letter in vocals:
        if letter in "aeiouAEIOU":
            voc = voc + 1
    return voc

phrase =input("Dime una palabra para sacar las vocales que contiene: ")

letter_number = count_vocals(phrase)

print("Tu palabra: " + str(phrase) + ", tiene: " + str(letter_number) + " vocales")

