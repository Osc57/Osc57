import java.util.Scanner;

/*
21. Reemplazar todas las vocales por un asterisco. Escribe una expresión regular
para reemplazar todas las vocales (mayúsculas y minúsculas) en una cadena de texto
por un asterisco (*).
• "Hola Mundo" → "H*l* M*nd*"
• "La casa es grande" → "L* c*s* *s gr*nd*"
*/
public class Ej21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime una frase: ");
        String frase = scanner.nextLine();


        String fraseModificada = frase.replaceAll("[aeiouAEIOU]", "*");

        System.out.println(fraseModificada);
    }
}
