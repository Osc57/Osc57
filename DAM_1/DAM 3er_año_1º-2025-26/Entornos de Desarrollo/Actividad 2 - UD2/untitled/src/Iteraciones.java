import java.util.Random;

public class Iteraciones {
    public static void main(String[] args) {
        // Crear un objeto Random para generar números aleatorios
        Random random = new Random();
        // Obtener un número aleatorio entre 1 y 10 (ambos incluidos)
        int iter = random.nextInt(5); // nextInt(20) genera un número entre 0 y 4
        int count = random.nextInt(10); // nextInt(20) genera un número entre 0 y 9

        System.out.println("Iteraciones: " + iter + " Números: " + count + ". Cantidad de números a generar: " + iter * count);

        for (int i = 0; i < iter; i++) {
            System.out.println("Iteración número: " + (i + 1));
            int j = 0;
            while (j < count) {
                System.out.println("-> Iter. " + j + ", valor de i: " + i);
                j++;
            }
        }
    }
}
