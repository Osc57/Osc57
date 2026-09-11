import java.util.Scanner;

/**
 * Crea una función que dada una nota numérica devuelva una nota de forma
 * textual: Suspenso, Aprobado, Notable y Sobresaliente.
 * **/
public class Ej7 {
    static void notas(int n){
        if (n >= 0 && n <= 4){
            System.out.println("Suspenso");
        } else if (n >= 5 && n <= 6) {
            System.out.println("Aprobado");
        } else if (n >= 7 && n <=8) {
            System.out.println("Notable");
        }else if (n >= 9 && n<= 10){
            System.out.println("Sobresaliente");
        }else {
            System.out.println("ERROR:La nota tiene que ser entre 0 y 10");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime la nota de tu exámen: ");
        int nota = scanner.nextInt();

        notas(nota);
    }
}
