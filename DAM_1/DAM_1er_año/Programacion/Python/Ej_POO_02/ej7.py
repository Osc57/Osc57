class Entretenimiento:
    #titulo, numero_de_temporadas, entregado, genero, creador
    #titulo, horas_estimadas, entregado, genero, compania

    def __init__(self, titulo, entregado, genero):
        self.titulo = titulo
        self.entregado = entregado
        self.genero = genero

    def entregar(self):
        self.entregado = True

    def devolver(self):
        self.entregado = False

    def is_entregado(self):
        return self.entregado


class Serie(Entretenimiento):
    titulo = str
    numero_de_temporadas = 3
    entregado = False
    genero = str
    creador = str

    def __init__(self, titulo, numero_de_temporadas, entregado, genero, creador):
        super().__init__(titulo, entregado, genero)
        self.numero_de_temporadas = numero_de_temporadas
        self.creador = creador

    def mostrar_info(self):
        print(f'{super().titulo} {self.numero_de_temporadas} {super().entregado} {super().genero} {self.creador}')

class Videojuego(Entretenimiento):
    titulo = str
    horas_estimadas = 10
    entregado = False
    genero = str
    compania = str

    def __init__(self, titulo, horas_estimadas, entregado, genero, compania):
        super().__init__(titulo, entregado, genero)
        self.horas_estimadas = horas_estimadas
        self.compania = compania


listaSerie = []
listaVideo = []
s1 = Serie("El señor de los anillos", False, "Ficción", 8, "Tolkin")
s2 = Serie("Juego de tronos", False, "Ficción", 6, "R.R.Martin")
v1 = Videojuego("GTA", 100, False, "Tiros", "Rockstar")

listaSerie.append(s1,)
listaSerie.append(s2)
listaVideo.append(v1)

s1.entregar()
v1.entregar()

numeroEntregados = 0
for serie in listaSerie:
    if serie.is_entregado():
        numeroEntregados += 1
        print(serie.titulo)

print("El numero de series entregadas es: " + str(numeroEntregados))

numeroEntregadosJuegos = 0
for juego in listaVideo:
    if juego.is_entregado():
        numeroEntregadosJuegos += 1
        print(juego.titulo)

print("El numero de series entregadas es: " + str(numeroEntregadosJuegos))
