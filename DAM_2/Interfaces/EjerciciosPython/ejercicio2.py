#Generación de Widgets en Python, botón

from PyQt6.QtWidgets import QApplication, QPushButton;

app = QApplication([]);

window = QPushButton("Pulsa");

window.show();

app.exec(); #Mantener ventana abierta
