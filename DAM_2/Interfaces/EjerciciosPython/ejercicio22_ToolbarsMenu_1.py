from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        etiqueta = QLabel("Hola")
        etiqueta.setAlignment(Qt.AlignmentFlag.AlignCenter)

        self.setCentralWidget(etiqueta)

        barraHerramientas = QToolBar("Barra de herramientas")
        self.addToolBar(barraHerramientas)

        btn = QAction("Mi botón", self)
        btn.setStatusTip("Este es mi botón")
        btn.triggered.connect(self.btnPressed)

        self.setStatusBar(QStatusBar(self))

        barraHerramientas.addAction(btn)

    def btnPressed(self, s):
        print("Pulsado", s)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
