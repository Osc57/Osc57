/*
3. Consulta la tabla de códigos ASCII y localiza los rangos de valores para las letras del
alfabeto A-Z y a-z. Crea un programa que pida al usuario que introduzca un número en
esos rangos y muestre por pantalla la letra correspondiente y si es o no una vocal.
*/

import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número entre 65 y 90 o del 97 al 122: ");
        int numero = scanner.nextInt();

        char letra = (char) numero;
        boolean vocal = false;

        vocal = letra == 65 || letra == 69 || letra == 73 || letra == 79 || letra == 85 || letra == 97 || letra == 101 || letra == 105 || letra == 111 || letra == 117;

        System.out.println("La letra es: " + letra +
                "\n" + "Es vocal: " + vocal);


    }
}
