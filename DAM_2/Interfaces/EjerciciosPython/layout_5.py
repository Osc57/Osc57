from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla = QStackedLayout()

        plantilla.addWidget(Color("red"))
        plantilla.addWidget(Color("green"))
        plantilla.addWidget(Color("blue"))
        plantilla.addWidget(Color("yellow"))

        plantilla.setCurrentIndex(0)

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
