'''Consiga la siguiente transformación:
12/31/20 ➡️31-12-2020'''

input_date = '12/31/20'
fecha_dividida = input_date.split('/')

dia = fecha_dividida[1]
mes = fecha_dividida[0]
year = '20' + fecha_dividida[2]

output_data = '-'.join([dia, mes, year])
print(output_data)

'''Dada una lista de números: 1, 25, 12, 4, 8 ,5 93, 4
Imprima la lista ordenada.'''

number_list = [1, 25, 12, 4, 8, 5, 93, 4]

read_list = len(number_list)

for i in range(read_list):
    for j in range(0, read_list - i - 1):
        if number_list[j] > number_list[j + 1]:
            number_list[j], number_list[j + 1] = number_list[j + 1], number_list[j]


print(number_list)

'''Dados dos vectores (listas) de la misma dimensión, utilice la función zip() para calcular su
producto escalar.
Entrada:'''
v1 = [4, 3, 8, 1]
v2 = [9, 2, 7, 3]

result = 0

for valor1, valor2 in zip(v1, v2):
    result = result + (valor1 * valor2)

print(result)

