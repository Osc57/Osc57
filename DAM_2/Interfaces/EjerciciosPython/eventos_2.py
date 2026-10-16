from PyQt6.QtCore import QDate, QSize;
from PyQt6.QtWidgets import QComboBox, QDateEdit, QApplication, QHBoxLayout, QLabel, QLineEdit, QMainWindow, QMenu, QPushButton, QVBoxLayout, QWidget, QTextEdit;
from PyQt6.QtGui import QAction

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Mi aplicacion")


    def contextMenuEvent(self, e):
        context = QMenu(self)
        context.addAction(QAction("Acción 1", self))
        context.addAction(QAction("Acción 2", self))
        context.addAction(QAction("Acción 3", self))
        context.exec(e.globalPos())


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
