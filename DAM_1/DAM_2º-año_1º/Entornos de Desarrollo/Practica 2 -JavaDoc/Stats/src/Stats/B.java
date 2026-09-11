
/** Esta es la clase de la práctica 2
 *
 * @author Óscar Úbeda
 * @since 14-11-2024
 * @version 1.0
 *
 */
public class B {

    static void showArray(double[] a) {
        for (int i = 0; i < a.length; i++) { //Recorro el array
            System.out.print(a[i] + " "); //Muestro los números contenidos en el array
        }
    }

    public static void main(String[] args) {
        double[] b = {45, 22, 34, 4, 32, 4, 2, 4, 3}; //Creo un array con números
        showArray(b); //Llamo al metodo con el array que he creado para que me muestre los números
    }
}
