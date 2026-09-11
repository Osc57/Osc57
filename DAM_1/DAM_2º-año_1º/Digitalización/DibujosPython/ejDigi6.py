import turtle
from turtle import *

width(5)
color("red")
penup()
goto(-100,100)
pendown()
for i in range(4):
    forward(50)
    right(90)

penup()
goto(50,100)
pendown()
for i in range(4):
    forward(50)
    right(90)

penup()
goto(-100,-50)
pendown()
for i in range(4):
    forward(50)
    right(90)

penup()
goto(50,-50)
pendown()
for i in range(4):
    forward(50)
    right(90)


turtle.done()