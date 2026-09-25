from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QVBoxLayout, QWidget;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla1 = QVBoxLayout()
        textoHolder = QHBoxLayout()
        checkHolder = QVBoxLayout()
        
        plantilla1.setContentsMargins(10,10,10,10)
        plantilla1.setSpacing(20)

        label = QLabel("Texto");
        
        texto = QLineEdit()

        textoHolder.addWidget(label)
        textoHolder.addWidget(texto)

        box1 = QCheckBox("Opción 1")
        box2 = QCheckBox("Opción 2")
        box3 = QCheckBox("Opción 3")

        checkHolder.addWidget(box1)
        checkHolder.addWidget(box2)
        checkHolder.addWidget(box3)

        plantilla1.addLayout(textoHolder)
        plantilla1.addLayout(checkHolder)

        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)

    

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
