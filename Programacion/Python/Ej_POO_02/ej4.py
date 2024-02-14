import random
from random import randint
class Persona:
    nombre = str
    edad = int
    DNI = str
    MUJER = 'm'
    sexo = MUJER
    peso = float
    altura = float
    
    def __init__(self, nombre, edad, sexo, peso, altura):
        self.__nombre = nombre
        self.__edad = edad
        self.DNI = self.generar_DNI()
        self.__sexo = sexo
        self.__peso = peso
        self.__altura = altura

    def calculaIMC(self):
        PESOIDEAL = 0
        PESOBAJO = -1
        PESOALTO = 1
        imc = self.__peso / (self.__altura) ** 2
        if imc < 20:
            return PESOBAJO
        elif imc >= 20 or imc < 25:
            return PESOIDEAL
        else:
            return PESOALTO

    def esMayorDeEdad(self):
        if self.__edad >= 18:
            return True
        if self.__edad < 18:
            return False

    def mostrar_informacion(self):
        print(f'Hola me llamo {self.nombre} tengo {self.edad} años mi DNI es {self.DNI} soy {self.sexo} peso {self.peso} Kg y mido {self.altura} metros')

    def generar_DNI(self):
        letras = ["T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"]
        numeros = random.randint(10000000, 99999999)
        letras_DNI = letras[numeros % 23]
        return str(numeros) + letras_DNI

    def calcular_sexo(self, sexo):
        if sexo == "H" or self.sexo == "M":
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
    def edad(self):
        return self.__edad

    @edad.setter
    def edad(self, edad):
        self.__edad = edad

    @property
    def sexo(self):
        return self.__sexo

    @sexo.setter
    def sexo(self, sexo):
        self.__sexo = sexo

    @property
    def peso(self):
        return self.__peso

    @peso.setter
    def peso(self, peso):
        self.__peso = peso

    @property
    def altura(self):
        return self.__altura

    @altura.setter
    def altura(self, altura):
        self.__altura = altura


persona = Persona("Juan", 20, "H", 70, 185)
persona.esMayorDeEdad()
persona.calculaIMC()
persona.mostrar_informacion()
