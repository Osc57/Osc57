/**
 * 2. Calcula el factorial de un número usando una función recursiva.
 * **/
fun recursiva(n: Int):Long{
    return if (n<= 1) 1
    else n*recursiva(n-1)
}
fun main() {
    print("Dime un número: ")
    val n = readln().toInt();

    print("El factorial de $n es ${recursiva(n)}")
}