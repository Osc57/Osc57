from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QHBoxLayout, QMainWindow, QVBoxLayout, QWidget;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla = QHBoxLayout()

        #plantilla = QVBoxLayout()

        plantilla.addWidget(Color("red"))
        plantilla.addWidget(Color("green"))
        plantilla.addWidget(Color("blue"))
        

        widget = QWidget()
        widget.setLayout(plantilla)
        self.setCentralWidget(widget)

        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
