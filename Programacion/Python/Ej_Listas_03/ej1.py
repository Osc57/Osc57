import random

number_list = []

for i in range(10):
    num = random.randint(1, 10)
    number_list.append(num)
    number_list.append(num**2)
    number_list.append(num**3)
print(number_list)


