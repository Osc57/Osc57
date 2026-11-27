from PyQt6.QtWidgets import QApplication, QComboBox, QHBoxLayout, QLabel, QVBoxLayout, QWidget, QTableWidget, QTableWidgetItem
from conexion import ConexionBD

class MainWindow(ConexionBD):
    def __init__(self):
        super().__init__()

        self.resize(450, 300)

        globalHolder = QVBoxLayout()

        #ComboBox
        comboBoxHolder = QHBoxLayout()
        label = QLabel("Seleccione una autonomía: ")
        self.comboBox = QComboBox()

        comboBoxHolder.addWidget(label)
        comboBoxHolder.addWidget(self.comboBox)
        
        # Tabla
        self.tabla = QTableWidget()
        
        globalHolder.addLayout(comboBoxHolder)
        globalHolder.addWidget(self.tabla)

        widget = QWidget()
        widget.setLayout(globalHolder)
        self.setCentralWidget(widget)

        self.cargarAutonomias()

        self.comboBox.currentTextChanged.connect(self.cargarDatos)

        self.cargarDatos()

    def cargarAutonomias(self):
        cursor = self.con.cursor()
        cursor.execute("SELECT DISTINCT Autonomía FROM capitales ORDER BY Autonomía")
        autonomias = [fila[0] for fila in cursor.fetchall() if fila[0] is not None]
        self.comboBox.addItems(autonomias)
        cursor.close()


    def cargarDatos(self):
        auto = self.comboBox.currentText()
  
        self.cursor = self.con.cursor()
        sql = "SELECT * FROM capitales WHERE Autonomía = %s"

        self.cursor.execute(sql, (auto,))
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
