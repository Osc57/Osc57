/**
 * Crea un programa que escriba en pantalla los números del 10 al 0
 * (descendiendo), usando "do..while".
 * **/
public class Ej7 {
    public static void main(String[] args) {
        int n1 = 10;

        do {
            System.out.println(n1--);
        }while (n1 >= 0);
    }
}
