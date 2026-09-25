from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QHBoxLayout, QMainWindow, QVBoxLayout, QWidget;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla1 = QHBoxLayout()
        plantilla2 = QVBoxLayout()
        plantilla3 = QVBoxLayout()

        plantilla2.addWidget(Color("red"))
        plantilla2.addWidget(Color("green"))
        plantilla2.addWidget(Color("blue"))
        

        plantilla3.addWidget(Color("red"))
        plantilla3.addWidget(Color("green"))
        plantilla3.addWidget(Color("blue"))
        
        plantilla1.addLayout(plantilla2)
        plantilla1.addWidget(Color("yellow"))
        plantilla1.addLayout(plantilla3)
        

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)

        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
