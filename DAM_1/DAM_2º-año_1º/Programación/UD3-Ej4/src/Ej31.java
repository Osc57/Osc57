/**
 * Realiza un programa que genere y muestre por pantalla 10 números
 * aleatorios entre 1 y 100. Después el programa debe mostrar el número
 * máximo y mínimo de la serie.
 * **/
public class Ej31 {
    public static void main(String[] args) {
        int minimo = 2147483647;
        int maximo = 0;

        for (int i = 0; i < 10; i++) {
            int aleatorio = (int) (Math.random()*100);
            System.out.println(aleatorio);

            if (aleatorio > maximo){
                maximo = aleatorio;
            }
            if (aleatorio < minimo){
                minimo = aleatorio;
            }
        }
        System.out.println("El número máximo: " + maximo);
        System.out.println("El número mínimo: " + minimo);
    }
}
