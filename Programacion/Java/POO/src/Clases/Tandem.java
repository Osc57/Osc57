package Clases;

import ClaseAbstracta.Bicicleta;

public class Tandem extends Bicicleta {

    private final String TIPO = "Tandem";
    private int numeroAsientos;

    public Tandem(String color, double precio, int numeroAsientos) {
        super(color, precio);
        if (numeroAsientos != 2 && numeroAsientos != 3){
            throw new RuntimeException("Solo se permiten 2 o 3 asientos");
        }
        this.numeroAsientos = numeroAsientos;

    }

    public String getTIPO() {
        return TIPO;
    }

    public int getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(int numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

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
