from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QGraphicsPixmapItem, QMainWindow, QCheckBox;
from PyQt6.QtGui import QPixmap;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        casilla = QCheckBox("Casilla de verificación");

        self.setCentralWidget(casilla);


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
