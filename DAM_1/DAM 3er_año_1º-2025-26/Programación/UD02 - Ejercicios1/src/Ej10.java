/*
10. Realiza un programa que genere letras mayúsculas aleatoriamente y determine si son
vocales o consonantes.
*/

public class Ej10 {
    public static void main(String[] args) {

        int valor1 = (int) (Math.floor(Math.random() * (65 - 90 + 1) + 90));

        char letra = (char) valor1;

        boolean vocal = false;
        boolean consonante = false;

        vocal = letra == 65 || letra == 69 || letra == 73 || letra == 79 || letra == 85;

        consonante = letra >= 66 && letra <= 68 || letra >= 70 && letra <= 72 || letra >= 74 && letra <= 78 || letra >= 80 && letra <= 84 || letra >= 86 && letra <= 90;

        System.out.println("La letra es: " + letra);

        if (vocal) {
            System.out.println("¿Es vocal?: Si");
        } else {
            System.out.println("¿Es vocal?: No");
        }

        if (consonante) {
            System.out.println("¿Es consonante?: Si");
        } else {
            System.out.println("¿Es consonante?: No");
        }


    }
}
