/*
10. Crea un programa que genere un array de 10 números aleatorios entre -10 y
10. El programa mostrará los números contenidos en el array. Después el
programa debe mostrar los elementos que no se repiten.
*/

public class Ej10 {
    public static void main(String[] args) {
        int[] aleatorios = new int[10];
        boolean[] noRepetidos = new boolean[10];

        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = (int) (Math.random() * 21) - 10;
            System.out.print(aleatorios[i] + " ");
        }

        System.out.println();
        for (int i = 0; i < aleatorios.length; i++) {
            int contador = 0;

            if (!noRepetidos[i]) {
                for (int j = 0; j < aleatorios.length; j++) {
                    if (aleatorios[i] == aleatorios[j]) {
                        contador++;
                        noRepetidos[j] = true;
                    }
                }

                if (contador == 1) {
                    System.out.print(aleatorios[i] + " ");
                }
            }
        }
    }
}
