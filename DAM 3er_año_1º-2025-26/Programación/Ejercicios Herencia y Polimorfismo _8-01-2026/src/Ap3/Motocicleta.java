package Ap3;

public class Motocicleta extends Vehiculo {

    public String hacerCaballito() {
        return "Has hecho un caballito";
    }

    @Override
    public String arrancar() {
        return "Brrm Brrm Motocicleta arrancada";
    }
}
