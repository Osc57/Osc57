package Practica;

import java.time.LocalDateTime;
import java.util.Comparator;

public class Paciente {
    private String nombre;
    private int gravedad;
    private LocalDateTime llegada;

    public Paciente(String nombre, int gravedad, LocalDateTime llegada) {
        this.nombre = nombre;
        this.gravedad = gravedad;
        this.llegada = llegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGravedad() {
        return gravedad;
    }

    public void setGravedad(int gravedad) {
        this.gravedad = gravedad;
    }

    public LocalDateTime getLlegada() {
        return llegada;
    }

    public void setLlegada(LocalDateTime llegada) {
        this.llegada = llegada;
    }


    public Paciente(String[] line) {
        this.nombre = line[1];
        this.gravedad = Integer.parseInt(line[2]);
        this.llegada = LocalDateTime.parse((line[3]));
    }

    public static Comparator<Paciente> comparadorGravedad() {
        return (p1, p2) -> Integer.compare(p2.getGravedad(), p1.getGravedad());
    }


    @Override
    public String toString() {
        return " Paciente-> " + "Nombre: " + nombre + " - Gravedad: " + gravedad + " - Llegada: " + llegada;

    }
}
