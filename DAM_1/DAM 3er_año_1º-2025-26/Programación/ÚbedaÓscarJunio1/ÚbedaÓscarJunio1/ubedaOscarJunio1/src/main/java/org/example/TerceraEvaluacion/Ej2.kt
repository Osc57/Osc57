package org.example.TerceraEvaluacion

import java.util.stream.IntStream.range

fun esCapicua(numero: Int): Boolean {
    var capicua: Boolean = false;

    val n: String = numero.toString();

    if (n == n.reversed()) {
        capicua = true
    }
    return capicua;
}

fun numerosCapicuaEnRango(inicio: Int, fin: Int): ArrayList<Int> {

    val numeros: ArrayList<Int> = ArrayList();

    for (n: Int in range(inicio, fin)) {
        if (esCapicua(n)){
            numeros.add(n)
        }
    }

    return numeros;
}

fun main() {
    for (n: Int in numerosCapicuaEnRango(1,100)){
        println(n)
    }
}