class Cuenta:
    titular = str
    cantidad = float

    def __init__(self, titular, cantidad):
        self.__titular = titular
        self.__cantidad = cantidad

    @property
    def titular(self):
        return self.__titular

    @titular.setter
    def titular(self, titular):
        self.__titular = titular

    @property
    def cantidad(self):
        return self.__cantidad

    @cantidad.setter
    def cantidad(self, cantidad):
        self.__cantidad = cantidad

    def mostrar(self):
        print(f'Hola {self.__titular}, tu cantidad es de {self.__cantidad} €')

    def ingresar(self, dinero):
        self.__cantidad = self.__cantidad + dinero
        if dinero < 0:
            self.__cantidad = self.__cantidad - dinero

    def retirar(self, dinero):
        self.__cantidad = self.__cantidad - dinero
        if self.__cantidad < 0:
            self.__cantidad = 0


persona1 = Cuenta("Juan", 200)

persona1.ingresar(20)
persona1.retirar(120)
persona1.mostrar()
persona1.retirar(300)
persona1.mostrar()



