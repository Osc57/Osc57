//Realiza un programa en Java que dada dos variables a y b, intercambie los valores de a
//y b sin utilizar una variable adicional para facilitar el intercambio.
public class Ej5 {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;

        a = a+b;
        b=a-b;
        a=a-b;

        System.out.println("Variable A -> "+ a + " ,Variable B -> " + b);
    }
}
