package Clases;

import ClaseAbstracta.Bicicleta;

public class BiciPaseo extends Bicicleta {

    private final String TIPO = "Bicicleta de Paseo";
    private int velocidad;

    public BiciPaseo(String color, double precio) {
        super(color, precio);
    }

    public BiciPaseo(String color, double precio, int velocidad) {
        super(color, precio);
        this.velocidad = velocidad;
    }

    public String getTIPO() {
        return TIPO;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "BiciPaseo{" +
                "TIPO='" + TIPO + '\'' + super.toString() +
                '}';
    }

    @Override
    public void pintar(String color) {

    }
}
