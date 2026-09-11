#Generación de una alerta + widgets + función

from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    contador = 0;
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        boton = QPushButton("Pulsa");
        boton.setCheckable(True);
        #boton.clicked.connect(self.botonPulsado);
        boton.clicked.connect(self.saberEstado);

        self.setCentralWidget(boton);

    def botonPulsado (self):
        print("Botón pulsado");
       
    def saberEstado(self, checked):
        if checked:
            self.contador += 1;
            if self.contador == 1:
                print ("Botón pulsado", self.contador, "vez");
            else:
                print("Botón pulsado", self.contador, "veces");
        else:
            print("Botón no pulsado");
        
        #print("¿Botón pulsado?",checked)

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
