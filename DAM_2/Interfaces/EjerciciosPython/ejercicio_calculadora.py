from unittest import result

from PyQt6.QtCore import QDate, QSize, Qt;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QDialog, QDialogButtonBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QRadioButton, QVBoxLayout, QWidget, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        globalHolder = QVBoxLayout()

        ####################################################
        numbersHolder = QHBoxLayout()
        self.descripcionLine = QTextEdit()
        self.descripcionLine.setFixedSize(QSize(300,80))
        self.descripcionLine.isLeftToRight()
        
        numbersHolder.addWidget(self.descripcionLine)
        ####################################################

        topPartHolder = QHBoxLayout()
        self.btn7 = QPushButton("7")
        self.btn8 = QPushButton("8")
        self.btn9 = QPushButton("9")

        topPartHolder.addWidget(self.btn7)
        topPartHolder.addWidget(self.btn8)
        topPartHolder.addWidget(self.btn9)

        self.btn7.clicked.connect(self.escribirCaracter)
        self.btn8.clicked.connect(self.escribirCaracter)
        self.btn9.clicked.connect(self.escribirCaracter)
        
        ####################################################

        topMidHolder = QHBoxLayout()
        self.btn4 = QPushButton("4")
        self.btn5 = QPushButton("5")
        self.btn6 = QPushButton("6")
        
        topMidHolder.addWidget(self.btn4)
        topMidHolder.addWidget(self.btn5)
        topMidHolder.addWidget(self.btn6)

        self.btn4.clicked.connect(self.escribirCaracter)
        self.btn5.clicked.connect(self.escribirCaracter)
        self.btn6.clicked.connect(self.escribirCaracter)

        ####################################################
        midHolder = QHBoxLayout()
        self.btn1 = QPushButton("1")
        self.btn2 = QPushButton("2")
        self.btn3 = QPushButton("3")
                
        midHolder.addWidget(self.btn1)
        midHolder.addWidget(self.btn2)
        midHolder.addWidget(self.btn3)

        self.btn1.clicked.connect(self.escribirCaracter)
        self.btn2.clicked.connect(self.escribirCaracter)
        self.btn3.clicked.connect(self.escribirCaracter)

        ####################################################

        botMidHolder = QHBoxLayout()
        self.btnPlus = QPushButton("+")
        self.btn0 = QPushButton("0")
        self.btnEquals = QPushButton("=")
                
        botMidHolder.addWidget(self.btnPlus)
        botMidHolder.addWidget(self.btn0)
        botMidHolder.addWidget(self.btnEquals)

        self.btnPlus.clicked.connect(self.escribirCaracter)
        self.btn0.clicked.connect(self.escribirCaracter)

        self.btnEquals.clicked.connect(self.calcularOperacion)

        ####################################################
        botHolder = QHBoxLayout()
        btnCE = QPushButton("CE")

        botHolder.addWidget(btnCE)
        btnCE.clicked.connect(self.borrarDatos)
        ####################################################

        globalHolder.addLayout(numbersHolder)
        globalHolder.addLayout(topPartHolder)
        globalHolder.addLayout(topMidHolder)
        globalHolder.addLayout(midHolder)
        globalHolder.addLayout(botMidHolder)
        globalHolder.addLayout(botHolder)

        central_widget = QWidget()
        central_widget.setLayout(globalHolder)
        
        self.setCentralWidget(central_widget)

    def escribirCaracter(self):
        boton_pulsado = self.sender()
        nuevo_caracter = boton_pulsado.text()  
        texto_actual = self.descripcionLine.toPlainText()
    
        self.descripcionLine.setText(texto_actual + nuevo_caracter)

    def calcularOperacion(self):
    
        texto = self.descripcionLine.toPlainText()
        
        if "+" in texto:
            partes = texto.split("+")
     
            num1 = float(partes[0])
            num2 = float(partes[1])
            
            resultado =(int(num1)) + (int(num2))
            
            self.descripcionLine.setText(str(resultado))

        

    def borrarDatos(self):
        self.descripcionLine.clear()


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
