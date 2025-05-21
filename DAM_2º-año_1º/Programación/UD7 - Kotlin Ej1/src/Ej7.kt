/**
 * Ordena una lista de strings por longitud de menor a mayor.
 */
class Ej7 {

}

fun main() {
    val ej7 = Ej7();


    print("Cuantas frases vas a decir: ")
    val numero = readln().toInt();

    if (numero <= 0) {
        print("El número debe ser positivo")
        return;
    }

    val listaFrases = mutableListOf<String>();

    for (i in 1..numero) {
        print("Dime la frase: ");
        listaFrases.add(readln())
    }

    val frasesOrdenadas = listaFrases.sortedBy { listaFrases -> listaFrases.length }

    println("Frases ordenadas por longitud")
    for (frase in frasesOrdenadas) {
        println(frase)

    }

}