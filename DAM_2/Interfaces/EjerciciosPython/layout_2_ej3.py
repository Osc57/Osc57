from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QVBoxLayout, QWidget;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        plantilla1 = QVBoxLayout()

        buttonHolder = QHBoxLayout()
        lonelyButton = QHBoxLayout()

        btn1 = QPushButton("Botón 1")
        btn2 = QPushButton("Botón 2")

        buttonHolder.addWidget(btn1)
        buttonHolder.addWidget(btn2)

        btn3 = QPushButton("Botón 3")
        lonelyButton.addWidget(btn3)


        plantilla1.addLayout(buttonHolder)
        plantilla1.addLayout(lonelyButton)
       
        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)



app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
