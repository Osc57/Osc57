from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QGraphicsPixmapItem, QMainWindow, QLabel, QLineEdit, QVBoxLayout, QWidget;
from PyQt6.QtGui import QPixmap;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        label = QLabel();

        label.setPixmap(QPixmap("img/gato.jpg"))
        label.setScaledContents(True);

        self.setCentralWidget(label);


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
