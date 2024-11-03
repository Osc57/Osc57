/**
 * Crea un programa que genere un array de 10 números aleatorios entre -10 y
 * 10. Después el programa mostrará los valores por pantalla en una sola línea
 * separados por espacios. A continuación, mostrará cuántos de los números son
 * negativos.
 * **/
public class Ej6 {
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


    }
}
