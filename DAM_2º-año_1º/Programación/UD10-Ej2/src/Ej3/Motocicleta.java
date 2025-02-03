package Ej3;

public class Motocicleta extends Vehiculo{

    public Motocicleta(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String arrancar() {
        return "Motocicleta arrancada";
    }

    public String hacerCaballito(){
        return "Estoy haciendo un caballito";
    }
}
