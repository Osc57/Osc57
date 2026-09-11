class Persona:
    nombre = str
    apellidos = str
    dni = str
    direccion = str
    telefono = int

    def __init__(self, nombre, apellidos, dni, direccion, telefono):
        self.nombre = nombre
        self.apellidos = apellidos
        self.dni = dni
        self.direccion = direccion
        self.telefono = telefono


class Alumnos(Persona):
    perdidio_evalucaion = bool

    def __init__(self, nombre, apellidos, dni, direccion, telefono, perdido_evalucion):
        super().__init__(nombre, apellidos, dni, direccion, telefono)
        self.perdidio_evalucaion = perdido_evalucion


class Profesores(Persona):
    lista = [str]
    horario = str

    def __init__(self, nombre, apellidos, dni, direccion, telefono, horario):
        super().__init__(nombre, apellidos, dni, direccion, telefono)
        self.lista = []
        self.horario = horario


class Director(Profesores):
    complemento_economico = float
    num_horas_semanales = float
    anos_director = int

    def __init__(self, lista, horario, complemento_economico, num_horas_semanales, anos_director):
        super().__init__(lista, horario)
        self.complemento_economico = complemento_economico
        self.num_horas_semanales = num_horas_semanales
        self.anos_director = anos_director


class JefeDeEstudios(Profesores):
    complemento_economico = float
    localizable = bool  
    
    def __init__(self, lista, horario, complemento_economico, localizable):
        super().__init__(lista, horario)
        self.complemento_economico = complemento_economico
        self.localizable = localizable


class Instituto:
    direccion = str
    telefono = int
    director = str
    jefe_estudios = str

    def __init__(self, direccion, telefono, director, jefe_estudios):
        self.direccion = direccion
        self.telefono = telefono
        self.director = director
        self.jefe_estudios = jefe_estudios

    def matricular_alumnos(self, alumno):
        lista_alumnos = []
        clase = ["DAM1", "DAM2", "SMR1", "SMR2"]
        for persona in range(0, 31):
            for _ in range(len(lista_alumnos) - 1, -1, -1):
                if lista_alumnos[alumno] == alumno:
                    print("Este alumno ya esta matriculado")
                else:
                    lista_alumnos.append(alumno)
                for humano in clase:
                    if humano:
                        print("Esta persona esta matriculada en este clase")
                    else:
                        lista_alumnos.append(clase)


alumno1 = Alumnos("Juan", "Galve", 1562665, "Mi casa", "89459499T", True)

insti = Instituto("su casa", 4564564, "Juan", "Jose")
insti.matricular_alumnos(alumno1)
insti.mostrar_informacion()