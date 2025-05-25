package org.example.Modelo;

public class Trabajador {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected int telefono;
    protected String dni_jefe;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDni_jefe() {
        return dni_jefe;
    }

    public void setDni_jefe(String dni_jefe) {
        this.dni_jefe = dni_jefe;
    }

    @Override
    public String toString() {
        return dni + " - "+ nombre + " " + apellidos;
    }
}
