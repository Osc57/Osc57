from tkinter import *


canvas = Canvas(width=800, height=600, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [100,250,300,170,500,250]

canvas.create_oval(200, 200, 400, 400, outline="white", fill="red", width=1.5)
canvas.create_polygon(points,outline="blue",fill="blue", width=2)


mainloop()