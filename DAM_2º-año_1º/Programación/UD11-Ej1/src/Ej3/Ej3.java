package Ej3;
import java.util.*;

/**
 * Crea un programa que elija al azar 50 números entre 0 y 99. Después el programa
 * pedirá al usuario introducir un número entre 0 y 99 y le dirá cuántas veces aparece
 * dicho número en la lista.
 * **/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> numeros = new ArrayList<>();

        int contador = 0;
        int n  = 0;
        while (numeros.size() < 50){
            int numero = random.nextInt(100);
            numeros.add(numero);
        }
        System.out.print("Dime un número (0-99): ");

        if (scanner.hasNextInt()){
            n = scanner.nextInt();
            scanner.nextLine();

            for (int i = 0; i < numeros.size(); i++) {
                if (numeros.get(i).equals(n)){
                    contador++;
                }
            }
        }
        System.out.println("El número " + n + " se repite " + contador + " veces");
    }
}
