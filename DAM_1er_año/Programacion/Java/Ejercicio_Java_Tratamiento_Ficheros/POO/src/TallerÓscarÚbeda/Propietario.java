package POO.src.TallerÓscarÚbeda;

public class Propietario extends Persona{
    String direccion;
    public Propietario(String DNI, String nombre, String apellido) {
        super(DNI, nombre, apellido);
    }

    public Propietario(String DNI, String nombre, String apellido, String direccion) {
        super(DNI, nombre, apellido);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "direccion='" + direccion + '\'' +
                ", DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
