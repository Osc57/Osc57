#Generación de una ventana en python con una clase + botón

from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        boton = QPushButton("Pulsa");

        self.setCentralWidget(boton);
        


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
