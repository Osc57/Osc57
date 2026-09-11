package Clases;

import ClaseAbstracta.Bicicleta;

public class BiciMontania extends Bicicleta {

    final String TIPO = "Bicicleta de Montaña";
    private int marcha;

    public BiciMontania(String color, double precio, int marcha) {
        super(color, precio);
        if (marcha != 1 && marcha != 2 && marcha != 3 && marcha != 4 && marcha != 5 && marcha != 6){
            throw new RuntimeException("La marcha indicada no es posible");
        }
        this.marcha = marcha;
    }
    public  void aumentarMarcha(){
        if (this.marcha != 6){
            this.marcha ++;
        }
    }
    public  void bajarMarcha(){
        if (this.marcha != 1){
            this.marcha --;
        }
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
