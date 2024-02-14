class Contacto:
    nombre = str
    telefono = int
    email = str

    def __init__(self, nombre, telefono, email):
        self.nombre = nombre
        self.telefono = telefono
        self.email = email

    def muestra_info(self):
        print(f'{self.nombre}, {self.email}, {self.telefono}')

class Agenda:
    def __init__(self):
        self.listaContactos = []
    def addContacto(self, contacto):
        self.listaContactos.append(contacto)

    def listaContacto(self):
        for contacto in self.listaContactos:
            print(f'Hola {contacto.nombre}, con correo {contacto.email} y teléfono {contacto.telefono}')

    def buscarContacto(self, nombre):
        for contacto in self.listaContactos:
            if contacto.nombre == nombre:
                return contacto

    def editar_contacto(self, nombre, nuevoNombre, nuevoEmail, nuevoTelefono):
        contacto = self.buscarContacto(nombre)
        contacto.nombre = nuevoNombre
        contacto.email = nuevoEmail
        contacto.telefono = nuevoTelefono

    def cerrarAgenda(self):
        self.listaContactos = []


agenda = Agenda()

while True:
    opcion = int(input("menu: \n 1 Para Añadir contacto \n 2 Para Listar \n 3 Para Buscar \n 4 Para Editar \n 5 Salir \n Digame el número a presionar: "))
    match opcion:
        case 1:
            nombre = input("Dame un nombre: ")
            email = input("Dame un email: ")
            telefono = int(input("Dame un teléfono: "))
            contacto = Contacto(nombre, email, telefono)
            agenda.addContacto(contacto)
        case 2:
            agenda.listaContacto()
        case 3:
            nombre = input("Dame un nombre: ")
            contactoBuscado = agenda.buscarContacto(nombre)
            contactoBuscado.muestra_info()
        case 4:
            nombre = input("Dame el nombre que quieras buscar en la lista: ")
            contactoBuscado = agenda.buscarContacto(nombre)
            nombre = input("Dame el nombre de como lo quieres llamar: ")
            email = input("Dame un email para reemplazarlo: ")
            telefono = int(input("Dame un teléfono para reemplazarlo: "))
            contactoBuscado.nombre = nombre
            contactoBuscado.email = email
            contactoBuscado.telefono = telefono
        case 5:
            break
