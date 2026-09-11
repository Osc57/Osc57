class Empleado:
    nombre = str
    edad = int
    salario = float

    def __init__(self, nombre, edad, salario):
        self.nombre = nombre
        self.edad = edad
        self.salario = salario

    def calcular_bono(self):
        return self.salario * 0.10

    def mostrar_informacion(self):
        return (f'{self.nombre} {self.edad} {self.salario}')


class Desarrollador(Empleado):
    lenguaje = str

    def __init__(self, nombre, edad, salario, lenguaje):
        super().__init__(nombre, edad, salario)
        self.lenguaje = lenguaje

    def calcular_bono(self):
        return self.salario * 0.15

    def mostrar_informacion(self):
        print(f'{super().mostrar_informacion()} {self.lenguaje} {self.calcular_bono()}')


class Gerente(Empleado):
    departamento = str

    def __init__(self, nombre, edad, salario, departamento):
        super().__init__(nombre, edad, salario)
        self.departamento = departamento

    def calcular_bono(self):
        return self.salario * 0.20

    def mostrar_informacion(self):
        print(f'{super().mostrar_informacion()} {self.departamento} {self.calcular_bono()}')


d1 = Desarrollador("Pepe", 32, 1800.0, "Python")
d2 = Desarrollador("José", 37, 1900.0, "Java")
d3 = Desarrollador("Lucia", 28, 1300.0, "Kotlin")

g1 = Gerente("Antonio", 53, 2400.0, "BBDD")
g2 = Gerente("Luisa", 47, 2900.0, "Desarrollo")


d1.mostrar_informacion()
d2.mostrar_informacion()
d3.mostrar_informacion()
g1.mostrar_informacion()
g2.mostrar_informacion()



