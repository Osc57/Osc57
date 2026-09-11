import java.util.Scanner;

/**
 * Crea un programa que pida al usuario una frase. El programa deberá buscar
 * las letras ‘s’ independientemente de mayúsculas y minúsculas y mostrar
 * cuantas hay y en qué posición están.
 * **/
public class Ej20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.next().toLowerCase();

        int contador = 0;
        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 's'){
                contador++;
                System.out.println("La letra 's' esta en la posición " + i + " de la palabra");
            }
        }

        if (contador > 0){
            System.out.println("La letra 's' aparece " + contador + " vez/ces");
        }else {
            System.out.println("No se encontraron letras 's' en la frase");
        }
        scanner.close();
    }
}
