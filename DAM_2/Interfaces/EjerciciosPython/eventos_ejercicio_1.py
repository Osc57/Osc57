from unittest import result

from PyQt6.QtCore import QDate, QSize;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QDialog, QDialogButtonBox, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QVBoxLayout, QWidget, QTextEdit

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicación")

        globalholder = QVBoxLayout()
        ####################################################
        
        nombreHolder = QHBoxLayout()

        nombre = QLabel("Nombre:")
        self.nombreLine = QLineEdit()

        nombreHolder.addWidget(nombre)
        nombreHolder.addWidget(self.nombreLine)

        ####################################################

        apellidosHolder = QHBoxLayout()
        apelldios = QLabel("Apellidos:")
        self.apellidosLine = QLineEdit()

        apellidosHolder.addWidget(apelldios)
        apellidosHolder.addWidget(self.apellidosLine)

        ####################################################

        fechaHolder = QHBoxLayout()
        fecha = QLabel("Fecha de alta:")
        self.fechaDate = QDateEdit()

        self.fechaDate.setCalendarPopup(True)
        self.fechaDate.setMinimumDate(QDate(2006,1,1))

        fechaHolder.addWidget(fecha)
        fechaHolder.addWidget(self.fechaDate)

        ####################################################

        departamentoHolder = QHBoxLayout()
        departamento = QLabel("Departamento:")
        self.departamentoDesplegable = QComboBox()

        self.departamentoDesplegable.addItems(["Contabilidad","Administración","Producción"])

        departamentoHolder.addWidget(departamento)
        departamentoHolder.addWidget(self.departamentoDesplegable)

        ####################################################

        buttonHolder = QHBoxLayout()
        btnGrabar = QPushButton("Enviar")
        btnReset = QPushButton("Reset")

        buttonHolder.addWidget(btnGrabar)
        buttonHolder.addWidget(btnReset)

        btnGrabar.clicked.connect(self.botonEnviar)
        btnReset.clicked.connect(self.borrarDatos)

        ####################################################

        globalholder.addLayout(nombreHolder)
        globalholder.addLayout(apellidosHolder)
        globalholder.addLayout(fechaHolder)
        globalholder.addLayout(departamentoHolder)
        globalholder.addLayout(buttonHolder)

        central_widget = QWidget()
        central_widget.setLayout(globalholder)

        self.setCentralWidget(central_widget)
 
    

    def botonEnviar(self):
        texto_nombre = self.nombreLine.text()
        texto_apellido = self.apellidosLine.text()
   
        resultado = QMessageBox.question(
            self,
            "Confirmación",
            f"Si eres {texto_nombre} {texto_apellido} pulsa Sí",
            QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No,
            QMessageBox.StandardButton.No
        )

        if resultado == QMessageBox.StandardButton.No:
            self.borrarDatos()


    def borrarDatos(self):
        self.nombreLine.clear()
        self.apellidosLine.clear()
        self.fechaDate.setDate(QDate(2006, 1, 1))
        self.departamentoDesplegable.setCurrentIndex(0)
              

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
