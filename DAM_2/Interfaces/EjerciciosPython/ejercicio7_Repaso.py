#Generación de un boton pulsado, soltado y pulsado y soltado
#click, press y release
from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;
import time;

class MainWindow(QMainWindow):
    contador = 0.0;
    esta_pulsado = False 
    def __init__(self):
        super().__init__()

        self.botonPulsado = True;

        self.setWindowTitle("Mi aplicación");

        boton = QPushButton("Pulsa");
        boton.setCheckable(False);
        
        boton.pressed.connect(self.botonPresionado);
        boton.released.connect(self.botonRealesed);
        boton.clicked.connect(self.botonActivado);
        
        #boton.setChecked(self.botonPulsado);
    
        self.setCentralWidget(boton);

    def botonPresionado(self):
        print("Botón Pulsado");
        
        self.esta_pulsado = True;
        self.contador = 0.0;

        while self.esta_pulsado:
            time.sleep(0.1);
            self.contador += 0.1;
        
            QApplication.processEvents();

    def botonRealesed(self):
        print("Botón soltado");
        self.esta_pulsado = False;
        print("Has aguantado ", self.contador , " segundos con el botón presionado")
    
    def botonActivado(self, checked):
        print("Botón pulsado y soltado");

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
