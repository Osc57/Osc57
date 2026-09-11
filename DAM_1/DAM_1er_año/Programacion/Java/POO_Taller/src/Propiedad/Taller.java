package Propiedad;

import Humano.Cliente;
import Humano.Propietario;

import java.util.ArrayList;

public class Taller {
    private String nombre;
    private String direccion;
    private Propietario propietario;
    private ArrayList<Cliente>clientes;


    public Taller() {
        clientes = new ArrayList<>();
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

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public String toString() {
        return "Taller{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", propietario=" + propietario.identificate() +
                ", clientes=" + clientes +
                '}';
    }
    public  boolean addCliente(Cliente cliente){
        return clientes.add(cliente);
    }
}
