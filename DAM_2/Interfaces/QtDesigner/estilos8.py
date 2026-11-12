from ejercicio9_ui import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()

        self.setupUi(self)
        self.show()

        self.comboBox.currentIndexChanged.connect(self.cambiar_estilo)

    def cambiar_estilo(self):    
        with open(["Estilos/estilo1.qss","Estilos/estilo2.qss","Estilos/estilo3.qss"][self.comboBox.currentIndex()], "r") as f:
            app.setStyleSheet(f.read())

app = QApplication([])
#app.setStyle("Fusion")
# with open("Estilos/estilo5.qss", "r") as f:
#     app.setStyleSheet(f.read())

ventana = MainWindow()
app.exec()