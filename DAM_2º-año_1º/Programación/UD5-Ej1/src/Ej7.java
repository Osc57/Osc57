/**
 * Crea un programa que genere un array de 10 números aleatorios entre -10 y
 * 10. Después el programa mostrará los valores por pantalla en una sola línea
 * separados por espacios. A continuación, debe cambiar los números negativos
 * del array por el mismo valor positivo. El programa mostrará el array de nuevo.
 * **/
public class Ej7 {
    public static void main(String[] args) {
        int [] aleatorios = new int [10];

        int contador = 0;
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = (int) (Math.random()*21)-10;
            System.out.print(aleatorios[i] + " ");
            if (aleatorios[i] < 0){
                contador++;
            }
        }
        System.out.println();
        System.out.println("Hay " + contador + " números negativos");

        for (int i = 0; i < aleatorios.length; i++) {
            if (aleatorios[i] < 0){
                aleatorios[i] = -aleatorios[i];
            }
            System.out.print(aleatorios[i] + " ");
        }
    }
}
