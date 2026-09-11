from animal import Animal as Animal
from animal import Perro as Perro
from perrera import Perrera as Perrera

animalNormal = Animal("1a2b3c4d", "Macho")
chucho1 = Perro("1a2b3a", "Hembra", "patada")
chucho2 = Perro("1a2b3a44", "Macho", "Pitbull")
chucho3 = Perro("1a2b3a52", "Macho", "Salchicha")

animalNormal.hacer_sonido()
animalNormal.dame_info()

chucho1.hacer_sonido()
chucho3.dame_info()

perrera = Perrera("Camino de Santiago 15, Teruel", "Aurelio Martinez")
perrera.nuevo_perro(chucho1)
perrera.nuevo_perro(chucho2)
perrera.nuevo_perro(chucho3)

perrera.dame_la_informacion_de_la_perrera()

perrera.se_muere_perro(chucho1)
perrera.dame_la_informacion_de_la_perrera()