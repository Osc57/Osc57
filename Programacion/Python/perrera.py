from animal import Perro as Perro
class Perrera:
    direccion = str
    jefe = str
    lista_de_perros = []

    def __init__(self, direccion, jefe):
        self.direccion = direccion
        self.jefe = jefe

    def dame_la_informacion_de_la_perrera(self):
        print(f'La perrera está en {self.direccion} y su jefe es {self.jefe}'
              f' Ahora tenemos {self.lista_de_perros}')
        for perro in self.lista_de_perros:
            perro.dame_info()


    def nuevo_perro(self, perro):
        self.lista_de_perros.append(perro)

    def se_muere_perro(self, perro):
        self.lista_de_perros.remove(perro)
        print(f'El perro {perro} se murio')