from PyQt6.QtCore import QDate, QSize;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QVBoxLayout, QWidget, QTextEdit;

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

        descripcionHolder = QHBoxLayout()
        descripcion = QLabel("Descripción:")
        self.descripcionLine = QTextEdit()
        self.descripcionLine.setFixedSize(QSize(300,200))

        descripcionHolder.addWidget(descripcion)
        descripcionHolder.addWidget(self.descripcionLine)

        ####################################################

        buttonHolder = QHBoxLayout()
        btnGrabar = QPushButton("Grabar")
        btnReset = QPushButton("Reset")

        buttonHolder.addWidget(btnGrabar)
        buttonHolder.addWidget(btnReset)

        btnGrabar.clicked.connect(self.mandarDatosADescripcion)
        btnReset.clicked.connect(self.borrarDatos)

        ####################################################

        globalholder.addLayout(nombreHolder)
        globalholder.addLayout(apellidosHolder)
        globalholder.addLayout(fechaHolder)
        globalholder.addLayout(departamentoHolder)
        globalholder.addLayout(descripcionHolder)
        globalholder.addLayout(buttonHolder)

        central_widget = QWidget()
        central_widget.setLayout(globalholder)

        self.setCentralWidget(central_widget)

    def mandarDatosADescripcion(self):
        self.descripcionLine.setText(self.nombreLine.text())
        self.descripcionLine.append(self.apellidosLine.text())
        self.descripcionLine.append(self.fechaDate.date().toString("dd/MM/yyyy"))
        self.descripcionLine.append(self.departamentoDesplegable.currentText())
 


    def borrarDatos(self):
        self.nombreLine.clear()
        self.apellidosLine.clear()
        self.descripcionLine.clear()
        self.fechaDate.setDate(QDate(2006, 1, 1))
        self.departamentoDesplegable.setCurrentIndex(0)
              

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
