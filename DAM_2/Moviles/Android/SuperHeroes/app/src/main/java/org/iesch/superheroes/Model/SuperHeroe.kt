package org.iesch.superheroes.Model

import android.os.Parcel
import android.os.Parcelable


//1 - Me creo el objeto superheroe y lo hago parcelizable

class SuperHeroe(
    val nombre: String,
    val alterEgo: String,
    val bio: String,
    val power: Float
)

