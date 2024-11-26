package Ej1;

import java.util.ArrayList;

public class Personas {
    private ArrayList<Persona> listaPersonas;

    //Constructor clase personas
    public Personas() {
        this.listaPersonas = new ArrayList<>();
    }

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void mostrarPersonas() {
        for (Persona persona : listaPersonas) {
            System.out.println(persona);
        }
    }

    public double edadMedia() {
        if (listaPersonas.isEmpty()) return 0;
        int totalEdad = 0;
        for (Persona persona : listaPersonas) {
            totalEdad += persona.CalcularEdad();
        }
        return totalEdad / (double) listaPersonas.size();
    }

    public Persona personaMasEdad() {
        if (listaPersonas.isEmpty()) return null;
        Persona mayor = listaPersonas.get(0);

        for (Persona persona : listaPersonas) {
            if (persona.CalcularEdad() > mayor.CalcularEdad()) {
                mayor = persona;
            }
        }
        return mayor;
    }
}
