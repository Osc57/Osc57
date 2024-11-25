import java.util.Scanner;

/**
 * Desarrolla un programa que pida al usuario introducir un número entero. El
 * programa mostrará si el número es o no capicúa (para los números negativos
 * debe ignorar el signo).
 **/
public class Ej8 {
    static int numeroInverso(int num){
        String cadena = String.valueOf(num);
        String inversa = "";
        for (int i = cadena.length() -1 ; i >= 0; i--) {
            inversa = inversa + cadena.charAt(i);
        }

        return Integer.parseInt(inversa);
    }
    static int convertirPositivo  (int n){
        if (n < 0){
            n = n * -1;
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número: ");
        int numero = scanner.nextInt();
        
        System.out.println(convertirPositivo(numero));


    }
}
