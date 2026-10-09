from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.contador = 0

        self.setWindowTitle("Mi aplicación")

        etiqueta = QLabel("Hola!")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignLeft)

        self.setCentralWidget(etiqueta)


        self.setStatusBar(QStatusBar(self))

        #=======================================================
        barraHerramientas = QToolBar("Barra de herramientas")
        self.addToolBar(barraHerramientas)
        #=======================================================

        btnGuardar = QAction(QIcon("icons/disk.png"),"Guardar", self)
        btnGuardar.setStatusTip("Guardar archivo")

        btnNuevo = QAction(QIcon("icons/document.png"),"Nuevo", self)
        btnNuevo.setStatusTip("Nuevo archivo")

        btnAbrir = QAction(QIcon("icons/application-dock.png"),"Abir", self)
        btnAbrir.setStatusTip("Abrir archivo")

        menu = self.menuBar()
        menu_archivo = menu.addMenu("&Archivo")
        menu_archivo.addAction(btnGuardar)
        menu_archivo.addAction(btnNuevo)
        menu_archivo.addAction(btnAbrir)

        menu_ayuda = menu.addMenu("&Ayuda")

        btnX = QAction("X",self)
        btnX.setStatusTip("Siguenos en X")

        btnInstagram = QAction("Instagram",self)
        btnInstagram.setStatusTip("Siguenos en Instagram")

        menu_siguenos = menu_ayuda.addMenu("Siguenos")
        menu_siguenos.addAction(btnX)
        menu_siguenos.addAction(btnInstagram)

        #===================================================================================================
        barraHerramientas.addAction(btnGuardar)
        barraHerramientas.addAction(btnNuevo)
        barraHerramientas.addAction(btnAbrir)
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
