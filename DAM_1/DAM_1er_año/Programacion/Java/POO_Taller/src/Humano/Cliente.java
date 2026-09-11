package Humano;

import Maquina.Vehiculo;

import java.util.ArrayList;

public class Cliente extends Persona{
    private String telefono;
    private ArrayList<Vehiculo>vehiculos;
    public Cliente(String dni, String nombre) throws Exception {
        super(dni, nombre);
        vehiculos = new ArrayList<>();
    }

    public boolean addVehiculo(Vehiculo vehiculo){
        return vehiculos.add(vehiculo);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
