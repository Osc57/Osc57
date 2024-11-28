package Ej3;

import javax.print.DocFlavor;

public class DemoPoligonos {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo(7, 14);
        Rectangulo rectangulo = new Rectangulo(14, 28);
        Cuadrado cuadrado = new Cuadrado(14, 14);
        Circunferenia circunferenia = new Circunferenia(24);

        System.out.println("Área Triángulo: " + triangulo.calcularArea());
        System.out.println("Área Rectángulo: " + rectangulo.calcularArea());
        System.out.println("Área Cuadrado: " + cuadrado.calcularArea());
        System.out.println("Área Circunferencia: " + circunferenia.calcularArea());
    }
}
