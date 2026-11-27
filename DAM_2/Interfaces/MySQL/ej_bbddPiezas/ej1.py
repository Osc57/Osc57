from PyQt6.QtWidgets import QComboBox, QLabel, QLineEdit, QMainWindow, QApplication, QHBoxLayout, QPushButton, QTextEdit, QVBoxLayout, QWidget
from conexion import ConexionBD

class MainWindow(ConexionBD):
    def __init__(self):
        super().__init__()

        self.resize(450, 150)

        # Configuración de la interfaz
        globalHolder = QVBoxLayout()

        # Fila Id
        idHolder = QHBoxLayout()
        id = QLabel("Id:")
        self.idText = QLineEdit()
        idHolder.addWidget(id)
        idHolder.addWidget(self.idText)

        # Fila Nombre
        nombreHolder = QHBoxLayout()
        nombre = QLabel("Autonomía:")
        self.nombreText = QLineEdit()
        nombreHolder.addWidget(nombre)
        nombreHolder.addWidget(self.nombreText)

        # Fila Precio 
        precioHolder = QHBoxLayout()
        precio = QLabel("Precio:")
        self.precioText = QLineEdit()
        precioHolder.addWidget(precio)
        precioHolder.addWidget(self.precioText)

        #Fila Unidades
        unidadesHolder = QHBoxLayout()
        unidades = QLabel("Unidades:")
        self.unidadesText = QLineEdit()
        unidadesHolder.addWidget(unidades)
        unidadesHolder.addWidget(self.unidadesText)

        #Fila ComboBox
        comboBoxHolder = QHBoxLayout()
        label = QLabel("Tipo: ")
        self.comboBox = QComboBox()

        comboBoxHolder.addWidget(label)
        comboBoxHolder.addWidget(self.comboBox)

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
        globalHolder.addLayout(idHolder)
        globalHolder.addLayout(nombreHolder)
        globalHolder.addLayout(precioHolder)
        globalHolder.addLayout(unidadesHolder)
        globalHolder.addLayout(comboBoxHolder)
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
        sql = "SELECT * FROM piezas"

        cursor.execute(sql)
        self.resultado = cursor.fetchall()
        self.indice = 0

        if self.resultado:
            self.mostrar_registros()

    def cargarDatosTipo(self):
            cursor = self.con.cursor()
            sql = "SELECT * FROM tipo"
    
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
        self.idText.setText(str(self.registro[0])) 
        self.nombreText.setText(self.registro[1]) 
        self.precioText.setText(str(self.registro[2])) 
        self.unidadesText.setText(str(self.registro[3])) 
        self.comboBox.setCurrentIndex(self.registro[4])

    

    
    



app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()