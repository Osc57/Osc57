class Cliente:
    nombre = str
    cantidad = float

    def __init__(self, nombre, cantidad):
        self.nombre = nombre
        self.cantidad = cantidad

    def depositar(self, cantidad):
        self.cantidad += cantidad

    def extraer(self, cantidad):
        self.cantidad -= cantidad

    def mostrarInfo(self):
        print(f'{self.nombre} {self.cantidad}')

class Banco:
    cliente1 = Cliente("Juan", 300)
    cliente2 = Cliente("Pepe", 12)
    cliente3 = Cliente("Marta", 50)

    def operar(self):
        numeroCliente = int(input("Indica el número de cliente con el que quieres operar (1,2,3): "))
        opcion = int(input("1 para ingresar \n 2 para extraer: \n"))
        cantidad = float(input("Introduce la cantidad: "))

        match opcion:
            case 1:
                match numeroCliente:
                    case 1:
                        self.cliente1.depositar(cantidad)
                    case 2:
                        self.cliente2.depositar(cantidad)
                    case 3:
                        self.cliente3.depositar(cantidad)
            case 2:
                match numeroCliente:
                    case 1:
                        self.cliente1.extraer(cantidad)
                    case 2:
                        self.cliente2.extraer(cantidad)
                    case 3:
                        self.cliente3.extraer(cantidad)

    def depositoTotal(self):
        print(f'El deposito total es {self.cliente1.cantidad + self.cliente2.cantidad + self.cliente3.cantidad}')


banco = Banco()
banco.operar()
banco.operar()
banco.depositoTotal()