from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QDialogButtonBox,QDialog,QApplication, QLabel, QLayout, QMainWindow, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class CustomDialog(QDialog):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Cuadro de diálogo")

        btn = QDialogButtonBox.StandardButton.Ok | QDialogButtonBox.StandardButton.Cancel

        self.dialogBox = QDialogButtonBox(btn)
        self.dialogBox.accepted.connect(self.accept)
        self.dialogBox.rejected.connect(self.reject)

        self.plantilla = QVBoxLayout()
        mensaje = QLabel("Algo a sucedido ¿todo Ok?")
        self.plantilla.addWidget(mensaje)
        self.plantilla.addWidget(self.dialogBox)
        self.setLayout(self.plantilla)
        
