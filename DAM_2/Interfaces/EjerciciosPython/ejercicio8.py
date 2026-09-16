from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.contador = 0;

        self.setWindowTitle("Mi aplicación");

        self.boton = QPushButton("Pulsa");
        self.boton.setCheckable(True);

        self.boton.setChecked(True);

        self.boton.clicked.connect(self.botonActivado);
        
        #boton.setChecked(self.botonPulsado);
    
        self.setCentralWidget(self.boton);

    
    def botonActivado(self, checked):
        self.contador += 1;
        print(self.boton.isChecked());

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
