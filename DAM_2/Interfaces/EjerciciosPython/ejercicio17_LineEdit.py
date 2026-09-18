from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QListWidget, QMainWindow, QLineEdit;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        self.texto = QLineEdit();

        self.texto.setMaxLength(10);
        self.texto.setPlaceholderText("Introduce tu nombre....");

        #texto.textChanged.connect(self.textoCambiado);
        self.texto.returnPressed.connect(self.introPulsado)

        self.setCentralWidget(self.texto);

    def introPulsado(self):
        print(self.texto.text());
        print("Intro pulsado");
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
