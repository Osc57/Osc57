class Articulo:
    id_objeto = int
    marca = str
    modelo = str
    precio = float

    def __init__(self, id_objeto, marca, modelo, precio):
        self.id_objeto = id_objeto
        self.marca = marca
        self.modelo = modelo
        self.precio = precio

    def dame_info(self):
        return ("el objeto " + str(self.id_objeto) + " cuya marca y modelo son: " + str(self.marca) +" y " + str(self.modelo) + ", con precio de: " + str(self.precio) + " €")


class Balones(Articulo):
    tipo_deporte = str

    def __init__(self, id_objeto, marca, modelo, tipo_deporte, precio):
        super().__init__(id_objeto, marca, modelo, precio)
        self.tipo_deporte = tipo_deporte

    def mostrar_balones(self):
        print(f'Él balón con {super().dame_info()}, para el deporte de {self.tipo_deporte}')


class Chandal(Articulo):
    color = str
    talla = str

    def __init__(self, id_objeto, marca, modelo, color, talla, precio):
        super().__init__(id_objeto, marca, modelo, precio)
        self.color = color
        self.talla = talla

    def mostrar_chandal(self):
        print(f'Tu chandal con {super().dame_info()}, con color {self.color} y de la talla {self.talla}')


class Camiseta(Articulo):
    color = str
    talla = str
    tipo = str
    composicion = str

    def __init__(self, id_objeto, marca, modelo, color, talla, tipo, composicion, precio):
        super().__init__(id_objeto, marca, modelo, precio)
        self.color = color
        self.talla = talla
        self.tipo = tipo
        self.composicion = composicion

    def mostrar_camisa(self):
        print(f'La camiseta con {super().dame_info()} con el color {self.color} la talla {self.talla} de tipo {self.tipo} y que esta hecho de {self.composicion}')


class Pantalones(Articulo):
    talla = str
    color = str
    longitud = float

    def __init__(self, id_objeto, marca, modelo, talla, color, longitud, precio):
        super().__init__(id_objeto, marca, modelo, precio)
        self.talla = talla
        self.color = color
        self.longitud = longitud

    def mostrar_pantalones(self):
        print(f'El pantalón con {super().dame_info()}, con la talla {self.talla}, de color {self.color} y siendo pantalón {self.longitud}')


class Tienda:

    def __init__(self):
        self.lista_balones = []
        self.lista_chandal = []
        self.lista_camisetas = []
        self.lista_pantalones = []
        self.recaudacion = 0.0

    def consulta_stock(self, elemento):
        if isinstance(elemento, Balones):
            print(f'El stock de balones es: {len(self.lista_balones)}')
        elif isinstance(elemento, Camiseta):
            print(f'El stock de camisetas es: {len(self.lista_camisetas)}')
        elif isinstance(elemento, Chandal):
            print(f'El stock de chandal es: {len(self.lista_chandal)}')
        elif isinstance(elemento, Pantalones):
            print(f'El stock de pantalones es: {len(self.lista_pantalones)}')

    def comprar(self, cliente):
        for articulo in cliente.lista_compra:
            if isinstance(articulo, Balones):
                self.lista_balones.remove(articulo)
                self.recaudacion += articulo.precio
            elif isinstance(articulo, Camiseta):
                self.lista_camisetas.remove(articulo)
                self.recaudacion += articulo.precio
            elif isinstance(articulo, Chandal):
                self.lista_chandal.remove(articulo)
                self.recaudacion += articulo.precio
            elif isinstance(articulo, Pantalones):
                self.lista_pantalones.remove(articulo)
                self.recaudacion += articulo.precio

    def mostrar_recaudacion_dia(self):
        print(f'La recaudación del dia es: {self.recaudacion}')

    def mostrar_objetos_a_la_venta(self):
        print("Balones a la venta son: ")
        for balones in self.lista_balones:
            balones.mostrar_balones()

        print("Camisetas a la venta: ")
        for camisetas in self.lista_camisetas:
            camisetas.mostrar_camisa()

        print("Chandals a la venta: ")
        for chandal in self.lista_chandal:
            chandal.mostrar_chandal()

        print("Pantalones a la venta: ")
        for vestimenta in self.lista_pantalones:
            vestimenta.mostrar_pantalones()

    def vender(self, articulo):
        if isinstance(articulo, Balones):
            self.lista_balones.append(articulo)
        elif isinstance(articulo, Camiseta):
            self.lista_camisetas.append(articulo)
        elif isinstance(articulo, Chandal):
            self.lista_chandal.append(articulo)
        elif isinstance(articulo, Pantalones):
            self.lista_pantalones.append(articulo)


class Cliente:

    def __init__(self):
        self.lista_compra = []
        self.coste_compra = 0.0

    def add_a_la_lista_de_la_compra(self, articulo):
        self.lista_compra.append(articulo)
        self.coste_compra += articulo.precio


balon = Balones("156578", "nike", "linux", "futbol", 33.6)
balon2 = Balones("155555", "nike", "aguacate", "futbol", 35.6)
balon3 = Balones("155234", "armidas", "ague", "volleyball", 25.6)
balon4 = Balones("123434", "juma", "liga absoluta", "tenis", 55.6)

camiseta = Camiseta("camisa1", "puma", "aero", "azul", "XL", "manga corta", "poliester",45.3)
camiseta2 = Camiseta("camisa2", "adidas", "guarna", "amarillo", "S", "manga corta", "poliester",45.3)

chandal = Chandal("chandal1", "puma", "froad", "negro", "XL", 59.99)
chandal2 = Chandal("chandal2", "armidas", "froad", "blanco", "L", 49.99)

pantalon = Pantalones("pantalon1", "adidas", "revista","XXL", "negro", "largo", 24.4)
pantalon2 = Pantalones("pantalon2", "puma", "sienraro","M", "vaquero", "largo", 34.4)

tienda = Tienda()
tienda.vender(balon)
tienda.vender(balon2)
tienda.vender(balon3)
tienda.vender(balon4)
tienda.vender(camiseta)
tienda.vender(camiseta2)
tienda.vender(chandal)
tienda.vender(chandal2)
tienda.vender(pantalon)
tienda.vender(pantalon2)
tienda.mostrar_objetos_a_la_venta()

cliente = Cliente()
cliente2 = Cliente()
tienda.mostrar_objetos_a_la_venta()

cliente.add_a_la_lista_de_la_compra(balon)
tienda.vender(cliente)

tienda.mostrar_recaudacion_dia()

