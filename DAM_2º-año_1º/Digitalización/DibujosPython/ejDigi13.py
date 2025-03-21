from tkinter import *


canvas = Canvas(width=800, height=600, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [100,250,300,170,500,250]

canvas.create_oval(200, 200, 400, 400, outline="black", fill="yellow", width=1.5)
canvas.create_polygon(points,outline="black",fill="brown", width=2)

canvas.create_line(280,290,230,280, width=3)
canvas.create_line(320,290,370,280, width=3)

canvas.create_line(280,355,320,355, width=3)


mainloop()