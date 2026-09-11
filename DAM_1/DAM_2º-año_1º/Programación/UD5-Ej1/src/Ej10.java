/**
 * Crea un programa que genere un array de 10 números aleatorios entre -10 y
 * 10. El programa mostrará los números contenidos en el array. Después el
 * programa debe mostrar los elementos que no se repiten.
 * **/
public class Ej10 {
    public static void main(String[] args) {
        int [] aleatorios1 = new int[10];
        boolean [] copiaAleatorios = new boolean[10];

        for (int i = 0; i < aleatorios1.length; i++) {
            aleatorios1[i] = (int) (Math.random() * 21) - 10;
            System.out.print(aleatorios1[i] + " ");
        }

        System.out.println();

        for (int i = 0; i < aleatorios1.length; i++) {
            int contador = 0;

            if (!copiaAleatorios[i]) {
                for (int j = 0; j < aleatorios1.length; j++) {
                    if (aleatorios1[i] == aleatorios1[j]) {
                        contador++;
                        copiaAleatorios[j] = true;
                    }
                }

                if (contador == 1) {
                    System.out.println("El número " + aleatorios1[i] + " no se repite");
                }
            }
        }
    }
}
