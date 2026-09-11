#Generación de una ventana en python con una clase

from PyQt6.QtCore import QSize, QtName;
from PyQt6.QtWidgets import QApplication, QMainWindow, QPushButton;

class MainWindow(QMainWindow):
    


app = QApplication([]);

window = QMainWindow();

window.show();

app.exec(); #Mantener ventana abierta
