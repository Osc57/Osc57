from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        etiqueta = QLabel("Hola")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter)

        self.setCentralWidget(etiqueta)

        barraHerramientas = QToolBar("Barra de herramientas")
        barraHerramientas.setIconSize(QSize(16,16))

        self.addToolBar(barraHerramientas)
        

        btn = QAction(QIcon("icons/bug.png"),"Botón bicho", self)
        btn.setStatusTip("Este es mi botón bicho")
        btn.triggered.connect(self.btnPressed)

        barraHerramientas.addSeparator()

        btn1 = QAction(QIcon("icons/cake.png"),"Botón tarta", self)
        btn1.setStatusTip("Este es mi botón tarta")
        btn1.triggered.connect(self.btnPressed)

        barraHerramientas.addSeparator()
        barraHerramientas.addWidget(QLabel("Texto"))
        barraHerramientas.addWidget(QCheckBox("Selección"))

        self.setStatusBar(QStatusBar(self))

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_editar = menu.addMenu("&Editar")
        menu_insertar = menu.addMenu("&Insertar")

        menu_archivo.addAction(btn)
        menu_archivo.addAction(btn1)
        menu.addSeparator()

        menu_mas = menu_archivo.addMenu("Más")
        menu_mas.addAction(btn)
        menu_mas.addAction(btn1)

        barraHerramientas.addAction(btn)
        barraHerramientas.addAction(btn1)

    def btnPressed(self, s):
        print("Pulsado", s)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
