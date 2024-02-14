class Persona:
    nombre = ""
    altura = 0
    peso = 0
    color_pelo = ""
    edad = 0

    def __init__(self, nombre, altura, peso, color_pelo, edad):
        self.nombre = nombre
        self.altura = altura
        self.peso = peso
        self.color_pelo = color_pelo
        self.edad = edad

    def mostrar(self):
        print(f'La persona tiene nombre de {self.nombre} tiene {self.edad} años, su altura es {self.altura} cm, pesa {self.peso} Kg y su pelo es {self.color_pelo}')

    def es_mayor_edad(self) -> bool:
        if self.edad >= 18:
            return True
        else:
            return False

    @property
    def nombre(self):
        return self.__nombre

    @nombre.setter
    def nombre(self, nombre):
        self.__nombre = nombre


    @property
    def altura(self):
        return self.__altura

    @altura.setter
    def altura(self, altura):
        if altura <0:
            self.__altura = 0
        else:
            self.__altura = altura

    @property
    def peso(self):
        return self.__peso

    @peso.setter
    def peso(self, peso):
        self.__peso = peso

    @property
    def color_pelo(self):
        return self.__color_pelo

    @color_pelo.setter
    def color_pelo(self, color_pelo):
        self.__color_pelo = color_pelo


oscar = Persona("Óscar", "190", 86, "marrón",20)
antonio = Persona("Antonio", "170", 76, "rubio", 17)
aurelio = Persona("Aurelio", "185", 96, "castaño", 23)

oscar.mostrar()
antonio.mostrar()
aurelio.mostrar()

print(oscar.es_mayor_edad())

