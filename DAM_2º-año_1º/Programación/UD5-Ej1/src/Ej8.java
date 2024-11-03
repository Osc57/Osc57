/**
 * Crea un programa que genere dos arrays de 10 números aleatorios entre -10 y
 * 10. El programa mostrará los valores de cada array. A continuación, el
 * programa creará un nuevo array de 10 números cuyos valores sean la suma
 * de los elementos con el mismo índice de los arrays obtenidos previamente.
 * Después se mostrarán los números almacenados en el array resultante.
 * **/
public class Ej8 {
    public static void main(String[] args) {
        int [] aleatorios1 = new int [10];
        int [] aleatorios2 = new int [10];
        int [] sumaAleatorios = new int[10];

        for (int i = 0; i < aleatorios1.length; i++) {
            aleatorios1[i] = (int) (Math.random()*21)-10;
            System.out.print(aleatorios1[i] + " ");
        }
        System.out.println();
        for (int j = 0; j < aleatorios2.length; j++) {
            aleatorios2[j] = (int) (Math.random() * 21) - 10;
            System.out.print(aleatorios2[j] + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            sumaAleatorios[i] = aleatorios1[i] + aleatorios2[i];
            System.out.print(sumaAleatorios[i] + " ");
        }




    }
}
