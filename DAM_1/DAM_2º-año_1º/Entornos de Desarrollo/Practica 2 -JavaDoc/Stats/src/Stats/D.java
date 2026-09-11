
/** Esta es la clase de la práctica 2
 *
 * @author Óscar Úbeda
 * @since 14-11-2024
 * @version 1.0
 *
 */
public class D {

    static double getMax(double[] a) {
        double mayor = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] > mayor) {
                mayor = a[i];
            }
        }
        return mayor;
    }

    public static void main(String[] args) {
        double[] d = {33, 45, 120, 77, 49, 12};//Me creo un Array
        System.out.println(getMax(d));//Llamo al método
    }
}
