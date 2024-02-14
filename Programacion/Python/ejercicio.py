class MobilePhone:
    manufacturer = str
    screen_size = float
    num_cores = int
    apps = []
    status = bool #False = Teléfono apagado, True = Teléfono encendido

    def __init__(self, manufacturer, screen_size, num_cores):
        self.manufacturer = manufacturer
        self.screen_size = screen_size
        self.num_cores = num_cores
        self.status = False


    def power_on(self):
        if self.status == False:
            self.status = True


    def power_off(self):
        if self.status == True:
            self.status = False

    def install_app(self, app):
        if app not in self.apps:
            self.apps.append(app)
        else:
            print("La aplicación ya estaba instalada")

    def uninstall_app(self, app):
        if app in self.apps:
            self.apps.remove(app)
        else:
            print("La aplicación no estaba instalada")

    def mostrar_todo(self):
        print(f'{self.manufacturer} {self.screen_size} {self.num_cores} {self.status} {self.apps}')

movil1 = MobilePhone("Xiaomi", 6.32, 8,)
movil1.install_app("Telegram")
movil1.install_app("Whatsapp")
movil1.install_app("Buscador de Google")

movil1.mostrar_todo()
movil1.uninstall_app("Telegram")
movil1.mostrar_todo()

