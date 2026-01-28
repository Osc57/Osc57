package Modelo;

import java.util.ArrayList;

public class Concesionario {
    private ArrayList<Vehiculos> listaVehiculos;

    public Concesionario() {
        listaVehiculos = new ArrayList<>();
    }

    public Concesionario(ArrayList<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public String mostrarVehiculos() {
        StringBuilder resultado = new StringBuilder();
        for (Vehiculos v : listaVehiculos) {
            resultado.append(v.toString()).append("\n");
        }
        return resultado.toString();
    }

    public Vehiculos vehiculoMasAntiguo() {
        if (listaVehiculos.isEmpty()) return null;

        Vehiculos mayor = listaVehiculos.getFirst();

        for (Vehiculos v : listaVehiculos) {
            if (mayor.getAnoFabricacion() > v.getAnoFabricacion()) {
                mayor = v;
            }
        }

        return mayor;
    }

    public ArrayList<Vehiculos> buscarVehiculo(String criterio) {
        ArrayList<Vehiculos> busquedaVehiculos = new ArrayList<>();

        if (listaVehiculos.isEmpty()) return null;

        for (Vehiculos v : listaVehiculos) {
            if (v.getMarca().equalsIgnoreCase(criterio) || v.getModelo().equalsIgnoreCase(criterio)) {
                busquedaVehiculos.add(v);
            }
        }

        return busquedaVehiculos;
    }

    public double precioPromedio() {
        if (listaVehiculos.isEmpty()) return 0;

        double suma = 0;
        for (Vehiculos v : listaVehiculos) {
            suma += v.getPrecio();
        }

        return suma / listaVehiculos.size();
    }


    public ArrayList<Vehiculos> getListaVehiculos() {
        return listaVehiculos;
    }

}
