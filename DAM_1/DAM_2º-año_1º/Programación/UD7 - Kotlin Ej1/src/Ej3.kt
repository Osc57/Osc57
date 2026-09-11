/**
 * Verifica si una palabra es un palíndromo (ignora mayúsculas/minúsculas).
 */

fun esPalindromo(cadena: String): Boolean {
    val cadenaLimpia = cadena.lowercase().replace("\\s+".toRegex(), "");
    return cadenaLimpia == cadenaLimpia.reversed();
}

fun main() {
    print("Dime una frase y te dire si es palindromo: ")
    val texto = readln();

    if (esPalindromo(texto)) {
        println("'$texto' es un palíndromo.")
    } else {
        println("'$texto' no es un palíndromo.")
    }
}