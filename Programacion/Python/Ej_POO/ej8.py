class Cuenta:
    titular = str
    cantidad = float

    def __init__(self, titular, cantidad):
        self.titular = titular
        self.cantidad = cantidad

    def muestraDatos(self):
        return (f'Titular: {self.titular}, Cantidad: {self.cantidad}')

class PlazoFijo(Cuenta):
    plazo = int
    interes = float

    def __init__(self, titular, cantidad, plazo, interes):
        super().__init__(titular, cantidad)
        self.plazo = plazo
        self.interes = interes

    def importe_del_interes(self):
        return self.cantidad * self.interes / 100

    def mostrar_info(self):
        print(f'Titular: {self.titular}, Cantidad: {self.cantidad}, Plazo: {self.plazo}, Interés: {self.interes}, Total Interes: {self.importe_del_interes()}')

class CuentaDeAhorro(Cuenta):
    numero_de_cuenta = int

    def __init__(self, titular, cantidad, ccc):
        super().__init__(titular, cantidad)
        self.numero_de_cuenta = ccc

    def muestraInfo(self):
        return (f'{self.muestraDatos()} + ccc: {self.numero_de_cuenta}')

cuentaAhorro = CuentaDeAhorro("Juan", 300.0, 18215005)
plazoFijo = PlazoFijo("Antonio", 500.0, 2, 2)

cuentaAhorro.muestraInfo()
plazoFijo.mostrar_info()