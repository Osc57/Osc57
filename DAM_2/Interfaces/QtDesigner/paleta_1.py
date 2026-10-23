from ejercicio4_ui import Ui_MainWindow
from PyQt6.QtWidgets import QMainWindow, QApplication
from PyQt6.QtCore import Qt
from PyQt6.QtGui import QPalette, QColor

class MainWindow(QMainWindow, Ui_MainWindow):
    def __init__(self):
        super(MainWindow, self).__init__()

        self.setupUi(self)
        self.show()

app = QApplication([])
app.setStyle("Fusion")

paleta = QPalette()
paleta.setColor(QPalette.ColorRole.Window, Qt.GlobalColor.gray)
paleta.setColor(QPalette.ColorRole.WindowText, QColor("#FFFFFF"))
paleta.setColor(QPalette.ColorRole.Button, QColor("#DBDBDB"))
paleta.setColor(QPalette.ColorRole.ButtonText, QColor("#0D0D0D"))
app.setPalette(paleta)

ventana = MainWindow()
app.exec()
