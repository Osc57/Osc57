from PyQt6.QtWidgets import QLabel, QLineEdit, QMainWindow, QApplication, QHBoxLayout, QTextEdit, QVBoxLayout, QWidget
import mysql.connector

class ConexionBD(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("Conectar BD")
        self.con = None

        try:
            self.con = mysql.connector.connect(
                host="localhost",
                port=3306,
                user="root",
                password = "1234",
                database = "capitales"
            )
        except mysql.connector.Error as error:
            print(error)
