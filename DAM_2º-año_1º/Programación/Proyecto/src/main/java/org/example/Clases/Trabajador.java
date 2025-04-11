package org.example.Clases;

public class Trabajador {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected int telefono;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

}
