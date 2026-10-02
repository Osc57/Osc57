from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QTabWidget, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        tabs = QTabWidget()
        tabs.setTabPosition(QTabWidget.TabPosition.North)
        tabs.setMovable(True)

        tabs.addTab(Color("red"), "rojo")
        tabs.addTab(Color("green"), "verde")
        tabs.addTab(Color("yellow"), "amarillo")
        tabs.addTab(Color("blue"), "azul")

        self.setCentralWidget(tabs)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
