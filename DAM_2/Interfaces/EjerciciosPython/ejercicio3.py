#Generación de una ventana en python

from PyQt6.QtWidgets import QApplication, QMainWindow;

app = QApplication([]);

window = QMainWindow();

window.show();

app.exec(); #Mantener ventana abierta
