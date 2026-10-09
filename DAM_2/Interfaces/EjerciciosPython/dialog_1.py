from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QDialog,QApplication, QCheckBox, QGridLayout, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QRadioButton, QStackedLayout, QStatusBar, QTabWidget, QToolBar, QVBoxLayout, QWidget, QGroupBox;
from cuadrado import Color
from PyQt6.QtGui import QAction, QIcon

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación")

        btn = QPushButton("Pulsa aquí")
        btn.clicked.connect(self.btnPressed)
        self.setCentralWidget(btn)



    def btnPressed(self, s):
        dialog = QDialog(self)
        dialog.setWindowTitle("Cuadro de diálogo")
        dialog.exec()
        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
