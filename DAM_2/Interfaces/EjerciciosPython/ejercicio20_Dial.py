from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QDial, QListWidget, QMainWindow, QLineEdit, QSpinBox, QSlider;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        dial = QDial()
        dial.setRange(-10,10)
        dial.setNotchesVisible(True)
        

        dial.valueChanged.connect(self.valorCambiado)
        dial.sliderMoved.connect(self.valorCambiado)

        self.setCentralWidget(dial);

    def valorCambiado(self, valor):
        print(valor)        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
