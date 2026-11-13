from PyQt6.QtWidgets import QLabel, QLineEdit, QMainWindow, QApplication, QHBoxLayout, QPushButton, QTextEdit, QVBoxLayout, QWidget
from conexion import ConexionBD

class MainWindow(ConexionBD):
    def __init__(self):
        super().__init__()

        self.resize(450, 150)

        # Configuración de la interfaz
        globalHolder = QVBoxLayout()

        # Fila Provincia
        provinciaHolder = QHBoxLayout()
        provincia = QLabel("Provincia:")
        self.provinciaText = QLineEdit()
        provinciaHolder.addWidget(provincia)
        provinciaHolder.addWidget(self.provinciaText)

        # Fila Autonomía
        autonomiaHolder = QHBoxLayout()
        autonomia = QLabel("Autonomía:")
        self.autonomiaText = QLineEdit()
        autonomiaHolder.addWidget(autonomia)
        autonomiaHolder.addWidget(self.autonomiaText)

        # Fila Población 
        poblacionHolder = QHBoxLayout()
        poblacion = QLabel("Población:")
        self.poblacionText = QLineEdit()
        poblacionHolder.addWidget(poblacion)
        poblacionHolder.addWidget(self.poblacionText)

        #Fila botones
        botonesHolder = QHBoxLayout()
        botonPrimero = QPushButton("<<")
        botonAnterior = QPushButton("<")
        botonSiguente = QPushButton(">")
        botonUltimo = QPushButton(">>")

        botonesHolder.addWidget(botonPrimero)
        botonesHolder.addWidget(botonAnterior)
        botonesHolder.addWidget(botonSiguente)
        botonesHolder.addWidget(botonUltimo)

        # Añadir filas al layout principal
        globalHolder.addLayout(provinciaHolder)
        globalHolder.addLayout(autonomiaHolder)
        globalHolder.addLayout(poblacionHolder)
        globalHolder.addLayout(botonesHolder)

        widget = QWidget()
        widget.setLayout(globalHolder)
        self.setCentralWidget(widget)


        widget = QWidget()
        widget.setLayout(globalHolder)
        self.setCentralWidget(widget)

        self.cargarDatos()

    def cargarDatos(self):
        cursor = self.con.cursor()
        sql = "SELECT * FROM capitales"

        cursor.execute(sql)
        resultado = cursor.fetchone()

        if resultado:
            self.provinciaText.setText(str(resultado[0]))
            self.autonomiaText.setText(str(resultado[1]))
            self.poblacionText.setText(str(resultado[2]))
        

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()