from unittest import result

from PyQt6.QtCore import QDate, QSize;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QDialog, QDialogButtonBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QRadioButton, QVBoxLayout, QWidget, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        globalHolder = QVBoxLayout()

        ####################################################

        buttonHolder = QHBoxLayout()
        aragon = QLabel("Aragón")
        self.rd1 = QRadioButton()
    
        comunidadValenciana = QLabel("Comunidad Valenciana")
        self.rd2 = QRadioButton()

        buttonHolder.addWidget(self.rd1)
        buttonHolder.addWidget(aragon)
        buttonHolder.addWidget(self.rd2)
        buttonHolder.addWidget(comunidadValenciana)

        self.rd1.toggled.connect(self.cambiarAragon)
        self.rd2.toggled.connect(self.cambiarValencia)
        
        ####################################################

        self.comboHolder = QHBoxLayout()

        self.globalCombo = QComboBox()

        self.comboHolder.addWidget(self.globalCombo)

        ####################################################

        globalHolder.addLayout(buttonHolder)
        globalHolder.addLayout(self.comboHolder)

        central_widget = QWidget()
        central_widget.setLayout(globalHolder)
        
        self.setCentralWidget(central_widget)

    def cambiarAragon(self):
        self.globalCombo.clear()
        self.globalCombo.addItems(["Huesca","Zaragoza","Teruel"])

    def cambiarValencia(self):
        self.globalCombo.clear()
        self.globalCombo.addItems(["Castellón","Valencia","Alicante"])

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
