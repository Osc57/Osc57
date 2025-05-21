/**
 * Dada una lista de números, encuentra el segundo mayor.
 */
class Ej5 {
    fun segundoMayor(lista: Array<Int>): Int? {
        return lista.distinct().sortedDescending().getOrNull(1)
    }
}
fun main(){
    val ej5 = Ej5();

    val listaNum = arrayOf(23,44,32,555,43,3);

    print("El segundo mayor es: " + ej5.segundoMayor(listaNum));
}