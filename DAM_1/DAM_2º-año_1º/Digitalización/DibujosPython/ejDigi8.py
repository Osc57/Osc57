from tkinter import *

canva = Canvas(width=640, height=480, bg="white")
canva.pack(expand=YES, fill=BOTH)
canva.create_line(0,0,320,200,fill="blue")
mainloop()