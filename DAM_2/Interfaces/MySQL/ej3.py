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

        self.cargarDatos()

    def cargarDatos(self):
        cursor = self.con.cursor()
        sql = "SELECT * FROM capitales"

        cursor.execute(sql)
        columnas = [desc[0] for desc in cursor.description]

        self.resultado = cursor.fetchall()

        self.tabla.setColumnCount(len(columnas))
        self.tabla.setRowCount(len(self.resultado))
        self.tabla.setHorizontalHeaderLabels(columnas)

        for fila, registro in enumerate(self.resultado):
            for col, valor in enumerate(registro):
                texto = "" if valor is None else str(valor)
                item = QTableWidgetItem(texto)

                self.tabla.setItem(fila,col,item)

        self.setCentralWidget(self.tabla)
        
       

app = QApplication([])
ventana = MainWindow()
ventana.show()
app.exec()
