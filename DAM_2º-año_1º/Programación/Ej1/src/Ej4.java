//Realiza un programa en Java que dada dos variables a y b, intercambie los valores de a
//y b. Tip: Utiliza una variable auxiliar c para guardar el valor de una variable y permitir el
//intercambio.
public class Ej4 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        int c;

        c=a;
        a=b;
        b=c;

        System.out.println("Variable A " + a);
        System.out.println("Variable B " + b);

    }
}
