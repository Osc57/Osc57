#Generación de una alerta + widgets

from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        boton = QPushButton("Pulsa");
        boton.setCheckable(True);
        boton.clicked.connect(self.botonPulsado);

        self.setCentralWidget(boton);

    def botonPulsado (self):
        print("Botón pulsado");
       


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
