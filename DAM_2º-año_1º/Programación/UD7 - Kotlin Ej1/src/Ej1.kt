/**
 * 1. Solicita dos números al usuario y muestra el mayor.
 * **/
fun main(){
    print("Dime un número: ")
    val n1 = readln().toInt();

    print("Dime otro número: ")
    val n2 = readln().toInt();

    if (n1> n2){
        println("$n1 Es el número más alto");
    }else{
        println("$n2 Es el número más alto");
    }
}