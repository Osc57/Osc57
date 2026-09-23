from PyQt6.QtCore import QSize, Qt;
from PyQt6.QtWidgets import QApplication, QComboBox, QDial, QListWidget, QMainWindow, QCalendarWidget;
from PyQt6.QtGui import QPixmap

class MainWindow(QMainWindow):
    def __init__(self):
        super().__init__()

        self.setWindowTitle("Mi aplicación");

        self.calendar = QCalendarWidget();
        self.calendar.selectionChanged.connect(self.mostrarFecha)

        self.setCentralWidget(self.calendar);

    def mostrarFecha(self):
        print(self.calendar.selectedDate().toString("dd/MM/yyyy"))        

app = QApplication([]);

window = MainWindow();

window.show();

app.exec(); #Mantener ventana abierta
