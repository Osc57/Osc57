package Ej3;

public class Circunferenia implements Poligono {
    private double radio;

    public Circunferenia(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(radio, 2);
    }
}
