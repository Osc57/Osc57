/*
8. Crea un programa que genere dos arrays de 10 números aleatorios entre -10 y
10. El programa mostrará los valores de cada array. A continuación, el
programa creará un nuevo array de 10 números cuyos valores sean la suma
de los elementos con el mismo índice de los arrays obtenidos previamente.
Después se mostrarán los números almacenados en el array resultante.
*/

public class Ej8 {
    public static void main(String[] args) {
        int[] aleatorios = new int[10];
        int[] aleatorios2 = new int[10];
        int[] sumaAleatorios = new int[10];

        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = (int) (Math.random() * 21) - 10;
            System.out.print(aleatorios[i] + " ");
        }

        System.out.println();
        for (int j = 0; j < aleatorios2.length; j++) {
            aleatorios2[j] = (int) (Math.random() * 21) - 10;
            System.out.print(aleatorios2[j] + " ");
        }

        System.out.println();
        System.out.println("------------------------------");
        for (int k = 0; k < 10; k++) {
            sumaAleatorios[k] = aleatorios[k] + aleatorios2[k];
            System.out.print(sumaAleatorios[k] + " ");
        }

    }
}
