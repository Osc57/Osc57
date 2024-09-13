chain_list = []
second_chain_list = []

for _ in range(1, 6):
    chain = input("Dime palabras: ")
    chain_list.append(chain)
    second_chain_list = chain_list[::-1]

print(f'La lista que has creado: {chain_list}')
print(f'La lista revertida: {second_chain_list}')