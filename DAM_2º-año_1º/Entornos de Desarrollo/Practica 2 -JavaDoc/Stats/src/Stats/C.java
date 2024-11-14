/** Esta es la clase de la práctica 2
*@author Óscar Úbeda
*@since 14-11-2024
*@version 1.0
**/
class C {

    static double getMin(double[] a) {
        double menor = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] < menor) {
                menor = a[i];
            }
        }
        return menor;
    }

    public static void main(String[] args) {
        double [] c = {33,45,120,77,49,12};
        double min = getMin(c);
        System.out.println(min);
    }
}
