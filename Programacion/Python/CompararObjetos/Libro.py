class Libro:

    def __init__(self, titulo="", autor=""):
        self.autor = autor
        self.titulo = titulo

    def __str__(self): #toString de Java en python
        return f"autor: {self.autor} titulo: {self.titulo}"

    def __eq__(self, other):
        if self.titulo == other.titulo and self.autor == other.autor:
            return True
        else:
            return False


if __name__ == "__main__": #Tipico main de Java
    listaConCuplicados = [Libro("Don quijote", "Cervantes"),Libro("Orgullo y prejuicio", "Jane Austen"),Libro("Frankenstein", "Mary Shelley"),Libro("Don quijote", "Cervantes"),Libro("Don quijote", "Cervantes"),Libro("Don quijote", "Cervantes"),Libro("Los tres mosqueteros", "Alexandre Dumas"),Libro("Don quijote", "Cervantes"),Libro("Cumbres borrascosas", "Emily Brontë")]
    listaSinDuplicados = list()

    for libro in listaConCuplicados:
        if not listaSinDuplicados.__contains__(libro):
            listaSinDuplicados.append(libro)

    #print(listaSinDuplicados)
    for libro in listaSinDuplicados:
        print(libro.__str__())

    #print(*listaSinDuplicados, sep=" || ") --> Esto printea main




