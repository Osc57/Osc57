package POO.src.TallerÓscarÚbeda;

import java.util.List;

public class Taller {
    String nombre;
    String direccion;
    String propietario;
    List<String>clientes;
    List<String>vehiculos;

    public Taller(String nombre, String direccion, String propietario, List<String> clientes, List<String> vehiculos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.propietario = propietario;
        this.clientes = clientes;
        this.vehiculos = vehiculos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public List<String> getClientes() {
        return clientes;
    }

    public void setClientes(List<String> clientes) {
        this.clientes = clientes;
    }

    public List<String> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<String> vehiculos) {
        this.vehiculos = vehiculos;
    }
    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", propietario='" + propietario + '\'' +
                ", clientes=" + clientes +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
