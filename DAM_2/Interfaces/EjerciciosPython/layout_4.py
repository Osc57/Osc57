from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla = QGridLayout()

        plantilla.addWidget(Color("red"),0,0)
        plantilla.addWidget(Color("green"),0,1)
        plantilla.addWidget(Color("yellow"),2,2)
        plantilla.addWidget(Color("blue"),3,0)

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
