package Clases;

import ClaseAbstracta.Bicicleta;

public class BiciMontania extends Bicicleta {

    final String TIPO = "Bicicleta de Montaña";

    public BiciMontania(String color, double precio) {
        super(color, precio);
    }

    @Override
    public String toString(){
        return "BiciMontania{" +
                "TIPO='" + TIPO + '\'' + super.toString() +
                '}';
    }

    @Override
    public void pintar(String color) {

    }
}
