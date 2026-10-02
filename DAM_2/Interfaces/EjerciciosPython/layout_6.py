from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        mainFraim = QVBoxLayout()
        buttonFrame = QHBoxLayout()

        btnRed = QPushButton("red")
        btnGreen = QPushButton("green")
        btnYellow = QPushButton("yellow")

        buttonFrame.addWidget(btnRed)
        buttonFrame.addWidget(btnGreen)
        buttonFrame.addWidget(btnYellow)

        self.plantilla = QStackedLayout()

        self.plantilla.addWidget(Color("red"))
        self.plantilla.addWidget(Color("green"))
        self.plantilla.addWidget(Color("yellow"))

        btnRed.clicked.connect(lambda: self.cambiar_color(0))
        btnGreen.clicked.connect(lambda: self.cambiar_color(1))
        btnYellow.clicked.connect(lambda: self.cambiar_color(2))

        mainFraim.addLayout(buttonFrame)
        mainFraim.addLayout(self.plantilla)
        
        widget = QWidget()
        widget.setLayout(mainFraim)
        self.setCentralWidget(widget)

    def cambiar_color(self, indice):
        self.plantilla.setCurrentIndex(indice)


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
