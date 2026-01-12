package Ap4;

import Ap3.Coche;
import Ap3.Motocicleta;
import Ap3.Vehiculo;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Publicacion> listaPubicaciones = new ArrayList<>();

        listaPubicaciones.add(new Libro("Libro Generico", "Paco", 144));
        listaPubicaciones.add(new Revista("Revista Generica", "Paca", 4));
        listaPubicaciones.add(new Libro("Libro Generico 2", "Francisco", 288));
        listaPubicaciones.add(new Revista("Revista Generica 2", "Francisca", 8));

        for (Publicacion p : listaPubicaciones) {
            System.out.println(p.mostrarInformacion());
        }
    }
}
