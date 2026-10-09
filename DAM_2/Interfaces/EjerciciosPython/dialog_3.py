from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QDialog,QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMessageBox, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        btn = QPushButton("Pulsa aquí")
        btn.clicked.connect(self.btnPressed)
        self.setCentralWidget(btn)



    def btnPressed(self):
        dlg = QMessageBox(self)
        dlg.setWindowTitle("Cuadro de mensaje")
        dlg.setText("Este es el mensaje de mi cuadro de mensaje")
        dlg.setStandardButtons(QMessageBox.StandardButton.Yes | QMessageBox.StandardButton.No)
        dlg.setIcon(QMessageBox.Icon.Information)

        if dlg.exec() == QMessageBox.StandardButton.Yes:
            print("El usuario ha aceptado")
        else:
            print("El usuario ha rechazado")
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
