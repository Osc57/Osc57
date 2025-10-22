/*
5. Crea un programa que escriba en pantalla los números pares del 26 al 10
(descendiendo), usando "while". (pista: en cada pasada habrá que descontar
2, por ejemplo haciendo i=i-2, que se puede abreviar i-=2).
*/

public class Ej5 {
    public static void main(String[] args) {

        int n = 28;

        while (n > 10) {
            System.out.println(n = n - 2);
        }
    }
}
