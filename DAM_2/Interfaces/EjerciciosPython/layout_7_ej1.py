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

        horizontalLayout = QHBoxLayout()
        verticalLayout = QVBoxLayout()

        
        label = QLabel("Hola")
        holaLine = QLineEdit()

        horizontalLayout.addWidget(label)
        horizontalLayout.addWidget(holaLine)


        contenedor_pestana1 = QWidget()
        contenedor_pestana1.setLayout(horizontalLayout)

        tabs.addTab(contenedor_pestana1, "pestaña1")
        
        casilla = QCheckBox("Selección");
        button = QPushButton("Pulsa")

        verticalLayout.addWidget(casilla)
        verticalLayout.addWidget(button)

        #tabs.addTab(holaLine, "pestaña1")

        contenedor_pestana2 = QWidget()
        contenedor_pestana2.setLayout(verticalLayout)

        tabs.addTab(contenedor_pestana2, "pestaña2")

        self.setCentralWidget(tabs)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
