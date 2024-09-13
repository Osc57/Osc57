package Humano;

public class Propietario extends Persona{
    private String direccion;
    public Propietario(String dni, String nombre) throws Exception {
        super(dni, nombre);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    @Override
    public String identificate(){
        return "Soy un propietario, mi DNI es " + this.getDni() + ", mi nombre es " + this.getNombre() + " mi direccion es: " + this.getDireccion();
    }
}
