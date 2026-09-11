class Persona:
    nombre = str
    edad = int
    DNI = str

    def __init__(self, nombre, edad, DNI):
        self.nombre = nombre
        self.edad = edad
        self.DNI = DNI

    def mostrar(self):
        print(f'Hola mi nombre es {self.nombre}, tengo {self.edad} años y mi DNI es {self.DNI}')

    def es_Mayor_de_edad(self):
        if self.edad < 18:
            print(f'Hola {self.nombre} cuya edad es de {self.edad} años, eres menor de edad')
        else:
            print(f'Hola {self.nombre} cuya edad es de {self.edad} años, eres mayor de edad')

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
    def DNI(self):
        return self.__DNI
    @DNI.setter
    def DNI(self, DNI):
        self.__DNI = DNI


persona1 = Persona("Javier", 15, "18756434G")
persona2 = Persona("Juan", 21, "18654532I")
persona1.mostrar()
persona2.mostrar()
persona1.es_Mayor_de_edad()
persona2.es_Mayor_de_edad()

