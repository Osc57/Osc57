class Libro:
    ISBN = str
    titulo = str
    autor = str
    numero_paginas = int

    def __init__(self, ISBN, titulo, autor, numero_paginas):
        self.__ISBN = ISBN
        self.__titulo = titulo
        self.__autor = autor
        self.__numero_paginas = numero_paginas

    @property
    def ISBN(self):
        return self.__ISBN

    @ISBN.setter
    def ISBN(self, ISBN):
        self.__ISBN = ISBN

    @property
    def titulo(self):
        return self.__titulo

    @titulo.setter
    def titulo(self, titulo):
        self.__titulo = titulo

    @property
    def autor(self):
        return self.__autor

    @autor.setter
    def autor(self, autor):
        self.__autor = autor

    @property
    def numero_paginas(self):
        return self.__numero_paginas

    @numero_paginas.setter
    def numero_paginas(self, numero_paginas):
        self.__numero_paginas = numero_paginas

    def mostrar(self):
        print(f'El libro con ISBN: {self.__ISBN} creado por el autor {self.__autor}, tiene {self.__numero_paginas} páginas')

    def mas_paginas(self, otro_libro):
        if libro1.__numero_paginas < otro_libro.__numero_paginas:
            print(f'El libro "{libro2.__titulo}" tiene más paginas que el libro "{libro1.__titulo}"')
        elif libro1.__numero_paginas > otro_libro.__numero_paginas:
            print(f'El libro "{libro1.__titulo}" tiene más paginas que el libro "{libro2.__titulo}"')
        else:
            print("Ambos libros tienen las mismas páginas")


libro1 = Libro("0758A64G852", "La bella durmiente", "Paquito", 350)
libro2 = Libro("075515481A5", "Paquito el chocolatero", "Manuel", 250)

libro1.mostrar()
libro2.mostrar()
libro1.mas_paginas(libro2)