package Ej3;

public class Rectangulo implements Poligono {
    private double base;
    private double altura;


    @Override
    public double calcularArea() {
        return base * altura;
    }
}
