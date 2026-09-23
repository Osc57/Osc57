from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QListWidget, QMainWindow, QLineEdit, QSpinBox;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        spinBox = QSpinBox();
        spinBox.setRange(-10,10);
        spinBox.setSingleStep(2)#Ir de 2 en 2 
        spinBox.setSuffix(" €")
        

        spinBox.valueChanged.connect(self.valorCambiado)
        spinBox.textChanged.connect(self.valorCambiado)

        self.setCentralWidget(spinBox);

    def valorCambiado(self, valor):
        print(valor)        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
