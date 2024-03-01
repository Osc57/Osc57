package Clases;

import ClaseAbstracta.Bicicleta;

public class BiciMontania extends Bicicleta {


    enum Marcha{
        PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA, SEXTA;

    }
    final String TIPO = "Bicicleta de Montaña";
    private Marcha marcha;

    public BiciMontania(String color, double precio, Marcha marcha) {
        super(color, precio);
        this.marcha = marcha;
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

    public String getTIPO() {
        return TIPO;
    }
}
