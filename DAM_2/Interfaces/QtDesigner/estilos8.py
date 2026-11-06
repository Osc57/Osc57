from ejercicio9_ui import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()

        self.setupUi(self)
        self.show()

        self.comboBox.currentIndexChanged.connect(self.cambiar_estilo)

    def cambiar_estilo(self, index):    
        estilos = {
            0: "Estilos/estilo1.qss",
            1: "Estilos/estilo2.qss",
            2: "Estilos/estilo3.qss",
        }

        with open(estilos.get(index), "r") as f:
            app.setStyleSheet(f.read())

app = QApplication([])
#app.setStyle("Fusion")
# with open("Estilos/estilo5.qss", "r") as f:
#     app.setStyleSheet(f.read())

ventana = MainWindow()
app.exec()