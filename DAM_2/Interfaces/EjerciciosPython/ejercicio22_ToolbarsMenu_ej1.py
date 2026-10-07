from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.contador = 0

        self.setWindowTitle("Mi aplicación")

        self.etiqueta = QLabel("Hola!")
        self.etiqueta.setAlignment(Qt.AlignmentFlag.AlignLeft)
        self.setCentralWidget(self.etiqueta)

        barraHerramientas = QToolBar("Barra de herramientas")
        barraHerramientas.setIconSize(QSize(16, 16))
        self.addToolBar(barraHerramientas)

        btn = QAction(QIcon("icons/bug.png"), "Cambiar texto", self)
        btn.triggered.connect(self.btnPressed)
        barraHerramientas.addAction(btn)

        self.setStatusBar(QStatusBar(self))

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_archivo.addAction(btn)

    def btnPressed(self, s):
        self.contador += 1
        self.etiqueta.setText(f"Texto cambiado {self.contador}")
            
    
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
