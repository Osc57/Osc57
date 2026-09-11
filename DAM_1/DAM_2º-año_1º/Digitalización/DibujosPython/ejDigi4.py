import turtle
from turtle import *

begin_fill()
color("red")
circle(50)

for i in range(4):
    forward(100)
    right(90)

end_fill()
hideturtle()

turtle.done()