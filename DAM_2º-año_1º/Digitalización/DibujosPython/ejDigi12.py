import turtle
from tkinter import *

canvas = Canvas(width=800, height=600, bg="white")
canvas.pack(expand=YES, fill=BOTH)

points = [0,200,100,0,200,200]

canvas.create_polygon(points,outline="blue",fill="green", width=2)

mainloop()