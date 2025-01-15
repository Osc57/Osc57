import java.util.Scanner;

/**
 * Reemplazar todas las vocales por un asterisco. Escribe una expresión regular
 * para reemplazar todas las vocales (mayúsculas y minúsculas) en una cadena de texto
 * por un asterisco (*).
 * • "Hola Mundo" → "H*l* M*nd*"
 * • "La casa es grande" → "L* c*s* *s gr*nd*"
 **/
public class Ej21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase remplazare las vocales por '*': ");
        String frase = scanner.nextLine();

        String fraseModificada = frase.replaceAll("[AEIOUaeiou]", "*");

        System.out.println(fraseModificada);

    }
}
