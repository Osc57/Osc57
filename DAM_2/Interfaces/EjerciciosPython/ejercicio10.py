from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        self.boton = QPushButton("Pulsa");

        self.boton.setCheckable(True);

        self.boton.clicked.connect(self.botonActivado);
    
        self.setCentralWidget(self.boton);

    
    def botonActivado(self, pulsado):
        self.boton.setText(["No Pulsado","Pulsado"][pulsado]);


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
