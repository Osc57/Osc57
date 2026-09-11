package Ej3;

public class Coche extends Vehiculo{
    public Coche(String marca, String modelo) {
        super(marca, modelo);
    }

    @Override
    public String arrancar() {
        return "Coche arrancado";
    }

    public String abrirMaletero(){
        return "Maletero abierto";
    }
}
