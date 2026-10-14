from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QDialog,QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()
        plantilla = QVBoxLayout()
        self.etiqueta = QLabel()
        plantilla.addWidget(self.etiqueta)

        self.setLayout(plantilla)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.window = OtraVentana()
        self.setWindowTitle("Mi aplicación")

        self.btn = QPushButton("Pulsa aquí")
        self.btn.clicked.connect(self.showWindow)

        self.input = QLineEdit()
        self.input.textChanged.connect(self.window.etiqueta.setText)

        plantilla = QVBoxLayout()
        
        plantilla.addWidget(self.input)
        plantilla.addWidget(self.btn)


        contenedor = QWidget()
        contenedor.setLayout(plantilla)

        self.setCentralWidget(contenedor)



    def showWindow(self):
        self.window.show()#Manenerse abierta
      

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
