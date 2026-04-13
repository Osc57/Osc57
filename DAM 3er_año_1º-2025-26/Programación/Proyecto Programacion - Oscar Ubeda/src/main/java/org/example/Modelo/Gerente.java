package org.example.Modelo;

public class Gerente extends Empleados {
    private double bono;
    private String nivel;

    public Gerente(double bono, String nivel) {
        this.bono = bono;
        this.nivel = nivel;
    }

    public Gerente(String dni, String nombre, String apellidos, String email, double salario, int departamento, double bono, String nivel) {
        super(dni, nombre, apellidos, email, salario, departamento);
        this.bono = bono;
        this.nivel = nivel;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
