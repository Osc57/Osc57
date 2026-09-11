from ej2 import Cuenta as Cuenta

class CuentaJoven(Cuenta):
    bonificacion = float
    edad = int

    def __init__(self, titular, cantidad, bonificacion, edad):
        super().__init__(titular, cantidad)
        self.__bonificacion = bonificacion
        self.edad = edad

    @property
    def bonificacion(self):
        return self.__bonificacion

    @bonificacion.setter
    def titular(self, bonificacion):
        self.__bonificacion = bonificacion

    def es_Titular_Valido(self):
        if self.edad >= 18 and self.edad <25:
            return True
        else:
            return False

    def retirar(self, cantidad):
        if self.es_Titular_Valido():
            self.cantidad -= self.cantidad
        else:
            print("Usted no puede retirar dinero")

    def muestra(self):
        print(f'Cuenta Joven, bonificacion: {self.bonificacion}')

cuenta_joven = CuentaJoven("Pepe", 200, 2.0, 19)
cuenta_joven.muestra()
cuenta_joven.retirar(100)
print(cuenta_joven.cantidad)
cuenta_joven.edad = 80
cuenta_joven.retirar(100)
print(cuenta_joven.cantidad)




