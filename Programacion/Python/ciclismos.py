import os
def calclaEquipoConMasCorredores(dict_numero_corredores_equipo):
    equipo_con_mas_corredores = max(dict_numero_corredores_equipo, key=dict_numero_corredores_equipo.get)
    print(f"El equipo con mas corredores es: {equipo_con_mas_corredores}")

def calclaEquipoConMenosCorredores(dict_numero_corredores_equipo):
    equipo_con_mas_corredores = min(dict_numero_corredores_equipo, key=dict_numero_corredores_equipo.get)
    print(f"El equipo con menos corredores es: {equipo_con_mas_corredores}")

def buscaCiclistaPorNombre(nombre, dict_ciclista_equipo):
    print(f'El ciclista {nombre} prtenece al equipo {dict_ciclista_equipo}')

def equipoConMenorEdad(dict_suma_equipo_edad, dict_numero_corredores_equipo):
    for equipo, suma_edad in dict_suma_equipo_edad.items():
        numero_de_corredores = dict_numero_corredores_equipo[equipo]
        media = suma_edad / numero_de_corredores
        dict_suma_equipo_edad[equipo] = media
    equipo_con_menor_media = min(dict_suma_equipo_edad, key=dict_suma_equipo_edad.get())
    print(f'El equipo con menor media es: {equipo_con_menor_media} con una media de {dict_suma_equipo_edad[equipo_con_menor_media]}')

def equipoConMayorEdad(dict_suma_equipo_edad, dict_numero_corredores_equipo):
    for equipo, suma_edad in dict_suma_equipo_edad.items():
        numero_de_corredores = dict_numero_corredores_equipo[equipo]
        media = suma_edad / numero_de_corredores
        dict_suma_equipo_edad[equipo] = media
    equipo_con_mayor_media = max(dict_suma_equipo_edad, key=dict_suma_equipo_edad.get())
    print(
        f'El equipo con menor media es: {equipo_con_mayor_media} con una media de {dict_suma_equipo_edad[equipo_con_mayor_media]}')

def interfazBuscaCiclistaPorNombre(dict_ciclista_equipo):
    nombre = input("Introdice el nombre a buscar: ")
    print(f'El ciclista con nombre {nombre} pertenece al equipo {dict_ciclista_equipo[nombre]}')

def buscaElPaisConMasCorredores(dict_pais_corredores):
    pais_con_mas_corredores = max(dict_pais_corredores, key=dict_pais_corredores.get)
    print(f'El equipo con más corredores es: {pais_con_mas_corredores} con {dict_pais_corredores[pais_con_mas_corredores]}')
if __name__ == '__main__':
    ruta = './Equipos'
    dict_numero_corredores_equipo = {}
    dict_ciclista_equipo = {}
    dict_suma_equipo_edad = {}

    dict_pais_corredores = {}
    #Obtener la lista de fichero:
    archivos = os.listdir(ruta)
    #Recorre la lista de archivos:
    for archivo in archivos:
        equipo = archivo.replace(".txt", "").replace(".", "")
        with open(f'{ruta}/{archivo}', 'r', encoding='utf-8') as file:
            for linea in file:
                partes = linea.split("|")
                nombre = partes[0].strip()# = .trim en java
                pais = partes[1].strip()
                edad = partes[2].replace("años"," ").strip()
                dict_numero_corredores_equipo[equipo] = dict_numero_corredores_equipo.get(equipo, 0) +1 #inicializa y suma en el caso de que tenga algo
                dict_ciclista_equipo[nombre] = equipo
                dict_suma_equipo_edad[equipo] = dict_suma_equipo_edad.get(equipo, 0) + 1 #init y suma
                dict_pais_corredores[pais] = dict_pais_corredores.get(pais, 0) + 1

calclaEquipoConMasCorredores(dict_numero_corredores_equipo)
calclaEquipoConMenosCorredores(dict_numero_corredores_equipo)
buscaCiclistaPorNombre("Jonas Vingegaard", dict_ciclista_equipo)
equipoConMenorEdad(dict_suma_equipo_edad,dict_numero_corredores_equipo)
equipoConMayorEdad(dict_suma_equipo_edad,dict_numero_corredores_equipo)
buscaElPaisConMasCorredores(dict_pais_corredores)
interfazBuscaCiclistaPorNombre(dict_ciclista_equipo)
