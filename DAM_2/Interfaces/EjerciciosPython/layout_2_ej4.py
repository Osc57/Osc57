from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        grupo1 = QGroupBox("Selección")
        grupo2 = QGroupBox("Botones")

        plantilla1 = QHBoxLayout()


        boxHolder = QVBoxLayout()
        buttonHolder = QVBoxLayout()

        grupo1.setLayout(boxHolder)

        box1 = QCheckBox("Opción 1")
        box2 = QCheckBox("Opción 2")
        box3 = QCheckBox("Opción 3")

        boxHolder.addWidget(box1)
        boxHolder.addWidget(box2)
        boxHolder.addWidget(box3)

        grupo2.setLayout(buttonHolder)
        
        btn1 = QPushButton("Botón 1")
        btn2 = QPushButton("Botón 2")
        btn3 = QPushButton("Botón 3")

        buttonHolder.addWidget(btn1)
        buttonHolder.addWidget(btn2)
        buttonHolder.addWidget(btn3)

        plantilla1.addWidget(grupo1)
        plantilla1.addWidget(grupo2)
    
       
        widget = QWidget()
        widget.setLayout(plantilla1)
        self.setCentralWidget(widget)



app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
