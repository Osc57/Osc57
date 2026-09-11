from tkinter import *

canva = Canvas(width=800, height=600, bg="white")
canva.pack(expand=YES, fill=BOTH)

x1=100
y1=100
x2=500
y2=500
for i in range(10):
    canva.create_oval(x1,y1,x2,y2,outline="white",fill="red",width = 1.5)
    x1+=10
    y1+=10
    x2-=10
    y2-=10
    canva.create_oval(x1, y1, x2, y2, outline="red", fill="white", width=1.5,)
    x1 += 10
    y1 += 10
    x2 -= 10
    y2 -= 10

mainloop()