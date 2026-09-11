/**
 * Crea una función que reciba un string y devuelva cuántas veces aparece cada letra.
 */

class Ej6 {
    fun apareceLetras(texto: String): List<Pair<Char, Int>>{
        val conteo = IntArray(26){0};
        val resultado = mutableListOf<Pair<Char, Int>>()

        for (caracter in texto.lowercase()){
            if (caracter in 'a'..'z'){
                val indice = caracter - 'a';
                conteo[indice]++
            }
        }

        for (letra in 'a'..'z'){
            val indice = letra - 'a';
            if (conteo[indice] > 0){
                resultado.add(letra to conteo[indice]);
            }
        }

        return resultado;
    }
}
fun main(){
    val ej6 = Ej6()

    print("Dime una frase para saber cuanto aparece cada letra: ")
    val frase = readln()

    print(ej6.apareceLetras(frase));
}