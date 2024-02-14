country = input("Dime un país : ")

flags = {
    "España": "emoji de la bandera de España",
    "Francia": "emoji de la bandera de Francia",
    "Portugal": "emoji de la bandera de Portugal",
    "Italia": "emoji de la bandera de Italia",
}

emoji_flags = flags.get(country)
if emoji_flags:
    print("La bandera de " + str(country) + " es: " + str(emoji_flags))
else:
    print("Los siento, pero el país que pusiste, no esta en nuestra base de datos, o, lo has puesto mal")