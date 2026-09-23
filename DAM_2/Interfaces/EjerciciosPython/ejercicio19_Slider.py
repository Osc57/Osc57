from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QListWidget, QMainWindow, QLineEdit, QSpinBox, QSlider;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        slider = QSlider(Qt.Orientation.Horizontal);
        slider.setRange(-10,10);
       
        

        slider.valueChanged.connect(self.valorCambiado)
        slider.sliderMoved.connect(self.valorCambiado)

        self.setCentralWidget(slider);

    def valorCambiado(self, valor):
        print(valor)        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
