package Figuras;

public class Main {

    public static void main(String[] args) {
        Circulo c1 = new Circulo("Circulo1", 12);
        Circulo c2 = new Circulo("Circulo2", 22);
        Rectangulo rectangulo = new Rectangulo("rectangulo", 12,6);

        System.out.println(c1.area());
        System.out.println(c2.perimetro());
        System.out.println(c1.toString());
        System.out.println(rectangulo.area());
        System.out.println(rectangulo.perimetro());
        System.out.println(rectangulo.toString());

    }
}
