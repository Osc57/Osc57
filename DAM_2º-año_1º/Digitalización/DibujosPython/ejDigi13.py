from tkinter import *

canvas = Canvas(width=800, height=600, bg="white")
canvas.pack(expand=YES, fill=BOTH)

x = 200
y = 200

for i in range(80):
    if i % 2 == 0:
        color = "blue"
    else:
        color = "red"

    canvas.create_text(x, y, text="hola", fill=color, font=("Arial", 52))

    y = y + 2
    x = x + 2

mainloop()
