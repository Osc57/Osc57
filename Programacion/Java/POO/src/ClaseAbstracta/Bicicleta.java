package ClaseAbstracta;

import Interf.Vehiculo;

public abstract class Bicicleta implements Vehiculo {
    private String color;
    private double precio;


    public Bicicleta() {
    }

    public Bicicleta(String color, double precio) {
        this.color = color;
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Bicicleta{" +
                "color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }

    public void pintar(String color){
        double costePintar = 90.0;
        this.precio = this.precio + costePintar;
    }
}
