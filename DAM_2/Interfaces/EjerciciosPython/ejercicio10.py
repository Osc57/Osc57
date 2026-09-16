from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        self.boton = QPushButton("Pulsa");

        self.boton.clicked.connect(self.botonActivado);
    
        self.setCentralWidget(self.boton);

    
    def botonActivado(self):
        self.boton.setText("Botón ya pulsado");
        self.boton.setEnabled(False);

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
