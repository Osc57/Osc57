from PyQt6.QtWidgets import QLabel, QLineEdit, QMainWindow, QApplication, QHBoxLayout, QPushButton, QTextEdit, QVBoxLayout, QWidget
from bbddProvincias.conexion import ConexionBD

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

        #Funcionalidad
        botonPrimero.clicked.connect(self.primero)
        botonAnterior.clicked.connect(self.anterior)
        botonSiguente.clicked.connect(self.sig)
        botonUltimo.clicked.connect(self.ultimo)


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
        self.resultado = cursor.fetchall()
        self.indice = 0

        if self.resultado:
            self.mostrar_registros()


    def primero(self):
        self.indice = 0
        self.mostrar_registros()

    def anterior(self):
        if self.indice > 0:
            self.indice -= 1
            self.mostrar_registros()

    def sig(self):
        if self.indice < len(self.resultado) - 1:
            self.indice += 1
            self.mostrar_registros()

    def ultimo(self):
        self.indice = len(self.resultado) - 1
        self.mostrar_registros()


    def mostrar_registros(self):
        self.registro = self.resultado[self.indice]
        self.provinciaText.setText(self.registro[0]) 
        self.autonomiaText.setText(self.registro[1]) 
        self.poblacionText.setText(str(self.registro[2])) 



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()