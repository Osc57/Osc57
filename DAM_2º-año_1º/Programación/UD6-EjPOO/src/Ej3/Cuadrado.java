package Ej3;

public class Cuadrado implements Poligono{
    private double base;
    private double altura;

    @Override
    public double calcularArea() {
        return base*altura;
    }
}
