from PyQt6.QtCore import QSize;
from PyQt6.QtWidgets import QApplication, QMainWindow, QLabel, QLineEdit, QVBoxLayout, QWidget;

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        label = QLabel("Hola");

        formato = label.font();
        formato.setPointSize(30);
        formato.setFamily("Arial");
        formato.setBold(True);


        self.setCentralWidget(label);


app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
