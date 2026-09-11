import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número para saber si es primo o no: ");
        int numero = scanner.nextInt();

        boolean primo = false;

        for (int i = 2; i < numero-1; i++) {
            if (numero % i != 0){
                primo=true;
            }else primo=false;

        }
        if (primo){
            System.out.println("Es primo");
        }else System.out.println("No es primo");

        scanner.close();
    }

}
