pais = input("Dime un país (este tiene que tener la primera en mayúscula): ")

banderas = {
    "España": "emoji de la bandera de España",
    "Francia": "emoji de la bandera de Francia",
    "Portugal": "emoji de la bandera de Portugal",
    "Italia": "emoji de la bandera de Italia",
}



emoji_bandera = banderas.get(pais)
if emoji_bandera:
    print("La bandera de " +str(pais)+ " es: " + str(emoji_bandera))
else:
    print("Los siento, pero el país que pusiste, no esta en nuestra base de datos, o, lo has puesto mal")