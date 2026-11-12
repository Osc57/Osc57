from ejercicio10_ui import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication


class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()

        self.setupUi(self)
        self.show()

        # self.btnVerdana.clicked.connect(lambda: self.cambiar_fuente("Verdana"))
        # self.btnArial.clicked.connect(lambda: self.cambiar_fuente("Arial"))
        # self.btnTahoma.clicked.connect(lambda: self.cambiar_fuente("Tahoma")) 
        
        self.pushButton.clicked.connect(lambda: self.label_4.setStyleSheet("color: green;"))
        self.pushButton_2.clicked.connect(lambda: self.label_4.setStyleSheet("color: red;"))
        self.pushButton_3.clicked.connect(lambda: self.label_4.setStyleSheet("color: blue;"))


        self.pushButton_4.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Verdana;"))
        self.pushButton_6.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Arial;"))
        self.pushButton_5.clicked.connect(lambda: self.label_4.setStyleSheet("font-family: Tahoma;"))


        self.pushButton_7.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 10px;"))
        self.pushButton_8.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 14px;"))
        self.pushButton_9.clicked.connect(lambda: self.label_4.setStyleSheet("font-size: 12px;"))

        
    
app = QApplication([])
app.setStyle("Window")
with open("Estilos/estilo6.qss", "r") as f:
    app.setStyleSheet(f.read())

ventana = MainWindow()
app.exec()