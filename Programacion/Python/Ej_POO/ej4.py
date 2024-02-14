class Triangulo:
    base = float
    lado1 = float
    lado2 = float

    def __init__(self, base, lado1, lado2):
        self.base = base
        self.lado1 = lado1
        self.lado2 = lado2

    def tipo_triangulo(self):
        if self.base == self.lado1 == self.lado2:
            print("Tu triángulo es equilátero")
        elif self.base != self.lado1 == self.lado2 or self.lado1 != self.base == self.lado2 or self.lado2 != self.base == self.lado1:
            print("Tu triángulo es isósceles")
        elif self.base != self.lado1 != self.lado2:
            print("Tu triángulo es escaleno")

    def lado_mayor(self):
        maximo = max(self.base, self.lado1, self.lado2)
        print(f'El lado más grande mide: {maximo}')


equilatero = Triangulo(23, 23, 23)
isosceles = Triangulo(32, 56, 32)
escaleno = Triangulo(32, 56, 43)

equilatero.tipo_triangulo()
equilatero.lado_mayor()
isosceles.tipo_triangulo()
escaleno.tipo_triangulo()
