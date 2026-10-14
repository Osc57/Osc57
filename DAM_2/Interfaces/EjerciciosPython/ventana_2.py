from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QDialog,QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class OtraVentana(QWidget):
    def __init__(self):
        super().__init__()
        plantilla = QVBoxLayout()
        self.etiqueta = QLabel("Otra ventana")
        plantilla.addWidget(self.etiqueta)

        self.setLayout(plantilla)


class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.window = None
        self.setWindowTitle("Mi aplicación")

        btn = QPushButton("Pulsa aquí")
        btn.clicked.connect(self.showWindow)
        self.setCentralWidget(btn)



    def showWindow(self):
        if self.window is None:
            self.window = OtraVentana()
            self.window.show()#Manenerse abierta
        else:
            self.window.close()
            self.window = None

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
