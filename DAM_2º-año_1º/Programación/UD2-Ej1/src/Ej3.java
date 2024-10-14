import java.util.Scanner;

/**
 * Consulta la tabla de códigos ASCII y localiza los rangos de valores para las letras del
 * alfabeto A-Z y a-z. Crea un programa que pida al usuario que introduzca un número en
 * esos rangos y muestre por pantalla la letra correspondiente y si es o no una vocal.
 * **/
public class Ej3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dime un número entre 65 y 90 o del 97 al 122: ");
        int numero = scanner.nextInt();

        char letra = 0;
        if (numero >= 65 && numero <=90){
            letra = (char)numero;
        } else if ((numero)>= 97 && numero <=122) {
            letra =(char)numero;
        }else {
            System.out.println("ERROR: Me has dado un número que no es el que me tienes que dar");
            scanner.close();
        }
        System.out.println("La letra es: " + letra);



    }
}
