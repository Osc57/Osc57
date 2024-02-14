def have_letters(text):

    ALPHABET = "abcdefghijklmnopqrstuvwxyz"
    for letter in text:
        if letter in ALPHABET:
            print("Tu frase es correcta")
        else:
            print("Tu frase tiene caracteres no alfabeticos")
        break

phrase = input("Dime una frase: ")

yes_or_no = have_letters(phrase)

