class Cuenta:
    titular = str
    cantidad = float

    def __init__(self, titular, cantidad):
        self.titular = titular
        self.cantidad = cantidad

    def mostrar(self):
        print(f'Hola me llamo {self.titular} y mi cantidad de dinero es {self.cantidad}')

    def ingresar(self, dinero):
        self.cantidad = self.cantidad + dinero

    def retirar(self, dinero):
        if self.cantidad < 0:
            print(f'Tu cuenta esta en números rojos {self.cantidad}')
        else:
            self.cantidad = self.cantidad - dinero

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


#persona1 = Cuenta("Fran", 123452)
#persona1.mostrar()

