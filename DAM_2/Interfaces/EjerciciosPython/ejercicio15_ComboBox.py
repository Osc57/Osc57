from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QMainWindow, QCheckBox;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        lista = QComboBox();

        lista.addItems(["Uno","Dos","Tres","Cuatro"]);
        lista.addItem("Cinco");

        lista.currentIndexChanged.connect(self.muestraIndice);
        lista.currentTextChanged.connect(self.muestraTexto);

        self.setCentralWidget(lista);


    def muestraIndice(self, s):
        print(s)

    def muestraTexto(self, s):
        print(s)

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
