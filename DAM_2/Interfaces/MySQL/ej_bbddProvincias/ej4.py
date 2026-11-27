from PyQt6.QtWidgets import QApplication, QComboBox, QHBoxLayout, QLabel, QLineEdit, QPushButton, QVBoxLayout, QWidget, QTableWidget, QTableWidgetItem
from bbddProvincias.conexion import ConexionBD

class MainWindow(ConexionBD):
    def __init__(self):
        super().__init__()

        self.resize(450, 300)

        globalHolder = QVBoxLayout()

        #Parte Arriba
        holder = QHBoxLayout()
        min = QLabel("Mínimo: ")
        self.minText = QLineEdit()

        max = QLabel("Máximo: ")
        self.maxText = QLineEdit()

        btn = QPushButton("Seleccionar")
        btn.clicked.connect(self.cargarDatos) 

        holder.addWidget(min)
        holder.addWidget(self.minText)
        holder.addWidget(max)
        holder.addWidget(self.maxText)
        holder.addWidget(btn)
        
        # Tabla
        self.tabla = QTableWidget()
        
        globalHolder.addLayout(holder)
        globalHolder.addWidget(self.tabla)

        widget = QWidget()
        widget.setLayout(globalHolder)
        self.setCentralWidget(widget)


    def cargarDatos(self):
        min = self.minText.text().strip()
        max = self.maxText.text().strip()
      
        self.cursor = self.con.cursor()
        sql = "SELECT * FROM capitales WHERE Población BETWEEN %s AND %s"
    
        self.cursor.execute(sql, (int(min), int(max)))
        columnas = [desc[0] for desc in self.cursor.description]
    
        self.resultado = self.cursor.fetchall()
    
        self.tabla.setColumnCount(len(columnas))
        self.tabla.setRowCount(len(self.resultado))
        self.tabla.setHorizontalHeaderLabels(columnas)
    
        for fila, registro in enumerate(self.resultado):
            for col, valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)
    
                self.tabla.setItem(fila, col, item)
    
     

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
