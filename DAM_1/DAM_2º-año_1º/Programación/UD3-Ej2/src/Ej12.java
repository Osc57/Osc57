/**
 * Crea un programa que escriba el alfabeto inglés en mayúsculas A-Z (sin la ñ,
 * claro está) utilizando un bucle y la conversión ASCII.
 * **/
public class Ej12 {
    public static void main(String[] args) {

        for (int i = 65; i <=90 ; i++) {
            char letra = (char)i;
            System.out.println(letra);
        }
    }
}
