package org.iesch.superheroes.Model

//1 - Me creo el objeto superheroe y lo hago parcelizable
@Parceli
data class SuperHeroe(
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val power: Float
)

