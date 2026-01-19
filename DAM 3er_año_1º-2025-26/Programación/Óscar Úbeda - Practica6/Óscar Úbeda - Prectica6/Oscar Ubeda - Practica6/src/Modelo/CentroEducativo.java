package Modelo;

import java.util.ArrayList;

public class CentroEducativo {
    private ArrayList<Trabajador> listaDetrabajadores;

    public CentroEducativo() {
        listaDetrabajadores = new ArrayList<>();
    }

    public CentroEducativo(ArrayList<Trabajador> listaDetrabajadores) {
        this.listaDetrabajadores = listaDetrabajadores;
    }

    public String anadirTrabajador(Trabajador trabajador) {
        if (listaDetrabajadores.isEmpty()) return "No hay trabajadores en la lista";

        if (trabajador == null) {
            return "ERROR: Trabajador no añadido por falta de datos";
        } else {
            listaDetrabajadores.add(trabajador);
        }
        return "Trabajador añadido";
    }

    public void mostrarTrabajadores() {
        if (listaDetrabajadores.isEmpty()) System.out.println("ERROR: No hay trabajadores");


        for (Trabajador t : listaDetrabajadores) {
            System.out.println(t);
        }

        /*
        for (Trabajador t : listaDetrabajadores) {
            if (t instanceof Profesor) {
                System.out.println((((Profesor) t).trabajar()));

            } else if (t instanceof PersonalAdministrativo) {
                System.out.println((((PersonalAdministrativo) t).trabajar()));
            }
        }
        */

    }

    public double salarioMedio() {
        if (listaDetrabajadores.isEmpty()) return 0.0;
        double suma = 0.0;

        for (Trabajador t : listaDetrabajadores) {
            suma = suma + t.getSalarioBase();
        }

        return suma / listaDetrabajadores.size();
    }

    public Trabajador trabajadorMayorAntiguedad() {
        Trabajador mayor = listaDetrabajadores.getFirst();

        for (Trabajador t : listaDetrabajadores) {
            if (t.antiguedad() > mayor.antiguedad()) {
                mayor = t;
            }
        }

        return mayor;
    }

    public ArrayList<Trabajador> buscarTrabajador(String busqueda) {
        ArrayList<Trabajador> lista = new ArrayList<>();

        for (Trabajador tra : listaDetrabajadores) {
            if (tra.getNombre().equalsIgnoreCase(busqueda)) {
                lista.add(tra);
            } else if (busqueda.equalsIgnoreCase("profesor") && tra instanceof Profesor) {
                lista.add(tra);
            } else if (busqueda.equalsIgnoreCase("administrativo") && tra instanceof PersonalAdministrativo) {
                lista.add(tra);
            }

        }

        return lista;
    }
}


