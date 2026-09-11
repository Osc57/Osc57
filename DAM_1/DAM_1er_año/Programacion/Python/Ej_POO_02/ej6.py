class Electrodomestico:
    CIEN = 100.0
    BLANCO = 'BLANCO'
    CONSUMO = 'F'
    PESO = 5.0
    precio_base = CIEN
    color = BLANCO
    consumo_energetico = CONSUMO
    peso = PESO

    def __init__(self, precio_base, color, consumo_energetico, peso):
        self.precio_base = precio_base
        self.color = color
        self.consumo_energetico = consumo_energetico
        self.peso = peso

    def cambia_color(self, color):
        if color.lower() not in ['blanco', 'negro', 'rojo', 'azul', 'gris']:
            print("Error, el color indicado no existe")
        else:
            self.color = color.lower()

    def comprobarConsumoEnergetico(self, consumo_energetico):
        if consumo_energetico.upper() in ['A', 'B', 'C', 'D', 'E', 'F']:
            self.consumo_energetico = consumo_energetico.upper()
        else:
            self.consumo_energetico = self.CONSUMO
            print("El consumo energético no es correcto")

    def precio_final(self):
        if self.consumo_energetico == 'A':
            self.precio_base += 100
        elif self.consumo_energetico == 'B':
            self.precio_base += 80
        elif self.consumo_energetico == 'C':
            self.precio_base += 60
        elif self.consumo_energetico == 'D':
            self.precio_base += 50
        elif self.consumo_energetico == 'E':
            self.precio_base += 30
        elif self.consumo_energetico == 'F':
            self.precio_base += 10

        if self.peso >= 0 and self.peso <=19:
            self.precio_base += 10
        elif self.peso >= 20 and self.peso <= 49:
            self.precio_base += 50
        elif self.peso >= 50 and self.peso <= 79:
            self.precio_base += 80
        elif self.peso >= 80:
            self.precio_base += 100

class Lavadora(Electrodomestico):
    KILOS = 5.0
    carga = KILOS

    def __init__(self, precio_base, color, consumo_energetico, peso, carga):
        super().__init__(precio_base, color, consumo_energetico, peso)
        self.carga = carga

    def precio_final(self):
        super().precio_final()
        if self.carga >= 30:
            self.precio_base += 50.0

class Television(Electrodomestico):
    resolucion = float
    tamano = 20.0
    sintonizador = False

    def __init__(self, precio_base, color, consumo_energetico, peso, resolucion, tamano, sintonizador):
        super().__init__(precio_base, color, consumo_energetico, peso)
        self.resolucion = resolucion
        self.tamano = tamano
        self.sintonizador = sintonizador

    def precio_final(self):
        super().precio_final()
        if self.resolucion > 40:
            self.precio_base = self.precio_base * 1.30
        if self.sintonizador == True:
            self.precio_base += 50

l1 = Lavadora(300.0, 'Negro', 'B', 60,20.0)
l2 = Lavadora(400.0, 'Gris', 'C', 50,25.0)
l3 = Lavadora(450.0, 'Gris', 'C', 50, 25)
Tv1 = Television(500.0,'Negro', 'A', 32, 1080, 58.0, True)

l1.precio_final()
l2.precio_final()
Tv1.precio_final()

print(f'{l1.precio_base}   {l2.precio_base}   {l3.precio_base}   {Tv1.precio_base}')






