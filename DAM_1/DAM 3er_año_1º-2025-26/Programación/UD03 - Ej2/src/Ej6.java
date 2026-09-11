/*
6. Crea un programa que escriba en pantalla los números del 2 al 8, usando
"do..while".
*/

public class Ej6 {
    public static void main(String[] args) {

        int n = 2;

        do {
            System.out.print(n++ + ", ");
        } while (n <= 8);
    }
}
