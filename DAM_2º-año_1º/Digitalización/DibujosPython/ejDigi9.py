from tkinter import *

canva = Canvas(width=640, height=480, bg="white")
canva.pack(expand=YES, fill=BOTH)
canva.create_oval(200,200,400,400,outline="black",fill="white",width = 2)
mainloop()

