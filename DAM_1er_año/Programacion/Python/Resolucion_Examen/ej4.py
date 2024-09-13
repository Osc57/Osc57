class Ficha:

    def __init__(self, numero, titulo):
        self.numero = numero
        self.titulo = titulo

    def mostrar_informacion(self):
        return (f'{self.numero} {self.titulo}')


class Libro(Ficha):

    def __init__(self, numero, titulo, autor, editorial):
        super().__init__(numero, titulo)
        self.autor = autor
        self.editorial = editorial

    def mostrar_informacion(self):
        print(f'{super().mostrar_informacion()} {self.autor} {self.editorial}')


class Revista(Ficha):

    def __init__(self, numero, titulo, num_revista, anno):
        super().__init__(numero, titulo)
        self.num_revista = num_revista
        self.anno = anno

    def mostrar_informacion(self):
        print(f'{super().mostrar_informacion()} {self.num_revista} {self.anno}')


class DVD(Ficha):

    def __init__(self, numero, titulo, director, anno, tipo):
        super().__init__(numero, titulo)
        self.director = director
        self.anno = anno
        self.tipo = tipo

    def mostrar_informacion(self):
        print(f'{super().mostrar_informacion()} {self.director} {self.anno} {self.tipo}')


class Blibioteca:
    datos_blibio = []

    def __int__(self, datos_blibio):
        self.datos_blibio = []

    def anadir_item(self, objeto):
        self.datos_blibio.append(objeto)

    def buscar_item(self, objeto):
        if objeto in self.datos_blibio:
            print(f'Tu objeto esta en la biblioteca')
        else:
            print(f'Tu objeto no esta en la biblioteca')

    def eliminar_item(self, objeto):
        if objeto in self.datos_blibio:
            self.datos_blibio.remove(objeto)
        else:
            print("El elemento que buscas no se encuentra en la blibioteca")

    def listado_blibio(self):
        for elemento in self.datos_blibio:
            elemento.mostrar_informacion()


libro1 = Libro(300, "Las maravillas de Juan", "Juan", "Juan and company")
dvd = DVD(301, "Lo que el viento se llevo", "Pepito", 1995, "Guerra")

blibioteca = Blibioteca()

blibioteca.anadir_item(libro1)
blibioteca.anadir_item(dvd)

blibioteca.buscar_item(libro1)
blibioteca.listado_blibio()
blibioteca.eliminar_item(libro1)
blibioteca.listado_blibio()




