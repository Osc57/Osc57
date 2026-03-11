package org.example.Modelo;

public class Empleados {
    private String dni;
    private String nombre;
    private String email;
    private double salario;

    public Empleados() {
    }

    public Empleados(String dni, String nombre, String email, double salario) {
        this.dni = dni;
        this.nombre = nombre;
        this.email = email;
        this.salario = salario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
