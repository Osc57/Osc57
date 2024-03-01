package Clases;

import ClaseAbstracta.Bicicleta;

public class BiciPaseo extends Bicicleta {

    private final String TIPO = "Bicicleta de Paseo";

    public BiciPaseo(String color, double precio) {
        super(color, precio);
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
