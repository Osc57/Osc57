class Circuito:
    nombre = str
    participantes = []

    def __init__(self, nombre):
        self.nombre = nombre
        self.participantes = []

    def add_participantes(self, participante):
        self.participantes.append(participante)


class Vehiculo:
    nombre = str
    dorsal = int
    velocidad_actual = 0
    velocidad_maxima = int
    tipo_combustible = str

    def __init__(self, nombre, dorsal, velocidad_actual, velocidad_maxima, tipo_combustible):
        self.nombre = nombre
        self.dorsal = dorsal
        self.velocidad_actual = velocidad_actual
        self.velocidad_maxima = velocidad_maxima
        self.tipo_combustible = tipo_combustible

    def acelerar(self, km):
        if self.velocidad_actual + km > self.velocidad_maxima:
            self.velocidad_actual = self.velocidad_maxima
        else:
            self.velocidad_actual += km
