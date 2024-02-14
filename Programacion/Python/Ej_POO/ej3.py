class Alumno:
    nombre = str
    nota_alumno = float

    def __init__(self, nombre, nota_alumno):
        self.nombre = nombre
        self.nota_alumno = nota_alumno

    def resultado(self):
        if self.nota_alumno < 5:
            print(f'Hola {self.nombre}, tu nota es {self.nota_alumno} y has suspendido')
        elif self.nota_alumno > 10:
            print("Nota no valida")
        elif self.nota_alumno < 0:
            print("Nota no valida")
        else:
            print(f'Hola {self.nombre}, tu notas es {self.nota_alumno} y has aprobado')


alumno1 = Alumno("Juan", 4.9)
alumno1.resultado()