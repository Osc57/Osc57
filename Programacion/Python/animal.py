class Animal:
    numero_de_identificacion = str
    sexo = str

    def __init__(self, numero_de_identificacion, sexo):
        self.numero_de_identificacion = numero_de_identificacion
        self.sexo = sexo

    def hacer_sonido(self):
        print("Haciendo sonido .....")

    def dame_info(self):
        print(f'Soy un animal y tengo el número: {self.numero_de_identificacion} y soy {self.sexo}')

class Perro(Animal):
    raza = str

    def __init__(self, numero_de_identificacion, sexo, raza):
        super().__init__(numero_de_identificacion, sexo)
        #Animal.__init__(numero_de_identificacion, sexo)
        self.raza = raza

    def hacer_sonido(self):
        print("Soy un Perro y ladro ....")

    def dame_info(self):
        print(f'Soy un animal y tengo el número: {self.numero_de_identificacion}, mi raza es: {self.raza} y soy {self.sexo}')
