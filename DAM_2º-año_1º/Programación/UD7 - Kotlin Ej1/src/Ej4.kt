/**
 * Dado un número, muestra si es primo.
 */

class Ej4 {
    fun esPrimo(n: Int): Boolean {
        if (n <= 1) return false
        if (n == 2) return true
        if (n % 2 == 0) return false
        for (i in 3..Math.sqrt(n.toDouble()).toInt() step 2) {
            if (n % i == 0) return false
        }
        return true
    }

}
fun main(){
    val ej4 = Ej4();

    print("Dime un número para saber si es primo o no: ")
    val numero = readln().toInt();

    if (ej4.esPrimo(numero)){
        print("El número es primo");
    }else{
        print("El número no es primo");
    }

}