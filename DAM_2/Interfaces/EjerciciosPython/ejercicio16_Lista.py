from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QListWidget, QMainWindow, QCheckBox, QAbstractItemView;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        lista = QListWidget();

        lista.addItems(["Uno","Dos","Tres","Cuatro"]);

        lista.currentTextChanged.connect(self.muestraTexto);

        lista.setSelectionMode(QAbstractItemView.SelectionMode.MultiSelection);#Elejir varios elementos de la lista
    

        self.setCentralWidget(lista);


    def muestraIndice(self, s):
        print(s)

    def muestraTexto(self, s):
        print(s)

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
