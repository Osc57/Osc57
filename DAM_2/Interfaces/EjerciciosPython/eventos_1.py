from PyQt6.QtCore import QDate, QSize;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QPushButton, QVBoxLayout, QWidget, QTextEdit;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicacion")


        self.etiqueta = QLabel("Pulsa aqui")
        self.setCentralWidget(self.etiqueta)

    def mouseMoveEvent(self, e):
        self.etiqueta.setText("El ratón se ha movido")

    def mousePressEvent(self, a0):
        self.etiqueta.setText("El ratón se ha pulsado")

    def mouseReleaseEvent(self, a0):
        self.etiqueta.setText("El ratón se ha dejado de pulsar")

    def mouseDoubleClickEvent(self, a0):
        self.etiqueta.setText("El ratón ha hecho un doble click")


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
