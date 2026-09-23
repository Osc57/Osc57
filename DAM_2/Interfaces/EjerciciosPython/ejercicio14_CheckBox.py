from PyQt6.QtCore import Qt 
from PyQt6.QtWidgets import QApplication, QMainWindow, QCheckBox
class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        casilla = QCheckBox("Casilla de verificación");
        formato = casilla.font();
        formato.setBold(True);

        casilla.setFont(formato);

        casilla.stateChanged.connect(self.muestraEstado);

        self.setCentralWidget(casilla);


    def muestraEstado(self, s):
        print(s)

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
