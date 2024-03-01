package Clases;

import ClaseAbstracta.Bicicleta;

public class Tandem extends Bicicleta {

    private final String TIPO = "Tandem";

    @Override
    public String toString() {
        return "Tandem{" +
                "TIPO='" + TIPO + super.toString() +
                '}';
    }

    @Override
    public void pintar(String color) {

    }
}
