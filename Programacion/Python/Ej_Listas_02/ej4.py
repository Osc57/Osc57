winners = []

for i in range(6):
    winners.append(int(input("Introduce el número ganador: ")))
winners.sort()

print("Los números ganadores son: " + str(winners))