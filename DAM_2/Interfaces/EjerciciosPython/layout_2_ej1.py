from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QHBoxLayout, QMainWindow, QPushButton, QVBoxLayout, QWidget;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

  
        plantilla1 = QVBoxLayout()
        
        plantilla1.setContentsMargins(10,10,10,10)
        plantilla1.setSpacing(20)

        boton1 = QPushButton("Botón 1")
        boton2 = QPushButton("Botón 2")
        boton3 = QPushButton("Botón 3")

        plantilla1.addWidget(boton1)
        plantilla1.addWidget(boton2)
        plantilla1.addWidget(boton3)


        boton1.clicked.connect(self.decirBotonPulsado)
        boton2.clicked.connect(self.decirBotonPulsado)
        boton3.clicked.connect(self.decirBotonPulsado)
        
        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)

    def decirBotonPulsado(self):
        print(f"Has pulsado el {self.sender().text()}")
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
