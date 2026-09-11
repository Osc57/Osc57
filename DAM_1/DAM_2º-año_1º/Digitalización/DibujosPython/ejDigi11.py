import turtle
from tkinter import *

canvas = Canvas(width=800, height=600, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [150,100,200,120,240,180,210,200,150,150,100,200]
canvas.create_polygon(points,outline="blue",fill="orange", width=2)

mainloop()