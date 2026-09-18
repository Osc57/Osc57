from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QListWidget, QMainWindow, QLineEdit;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        texto = QLineEdit();

        texto.setMaxLength(10);
        texto.setPlaceholderText("Introduce tu nombre....");

        #texto.textChanged.connect(self.textoCambiado);
        texto.returnPressed.connect(self.introPulsado)

        self.setCentralWidget(texto);


    def textoCambiado(self, s):
        print(s)

    def introPulsado(self):
        print("Intro pulsado")

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
