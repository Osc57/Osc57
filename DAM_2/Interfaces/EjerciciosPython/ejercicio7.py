#Generación de una alerta + widgets + función

from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.botonPulsado = True;

        self.setWindowTitle("Mi aplicación");

        boton = QPushButton("Pulsa");
        boton.setCheckable(True);
        boton.clicked.connect(self.botonActivado);
        boton.setChecked(self.botonPulsado);

        self.setCentralWidget(boton);

    def botonActivado(self, checked):
        self.botonPulsado = checked;
        print(self.botonPulsado);

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
