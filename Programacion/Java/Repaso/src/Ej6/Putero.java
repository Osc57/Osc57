package Ej6;

public class Putero {
    String nombre;
    String DNI;
    int Telefono;

    public Putero(String nombre, String DNI, int telefono) {
        this.nombre = nombre;
        this.DNI = DNI;
        Telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int telefono) {
        Telefono = telefono;
    }

    @Override
    public String toString() {
        return "Putero{" +
                "nombre='" + nombre + '\'' +
                ", DNI='" + DNI + '\'' +
                ", Telefono=" + Telefono +
                '}';
    }
}
