package org.example.Modelo;

public class Trabajador {
    protected String dni;
    protected String nombre;
    protected String apellidos;
    protected int telefono;
    protected boolean primerLogin = true;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Trabajador(String dni, String nombre, String apellidos, int telefono, boolean primerLogin) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.primerLogin = primerLogin;
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

    public boolean isPrimerLogin() {
        return primerLogin;
    }

    public void setPrimerLogin(boolean primerLogin){
        this.primerLogin = primerLogin;
    }

    @Override
    public String toString() {
        return dni + " - "+ nombre + " " + apellidos;
    }
}
