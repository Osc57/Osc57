package org.example.Modelo;

public class Gerente extends Empleados {
    private double bono;
    private int nivel;

    public Gerente(double bono, int nivel) {
        this.bono = bono;
        this.nivel = nivel;
    }

    public Gerente(String dni, String nombre, String email, double salario, double bono, int nivel) {
        super(dni, nombre, email, salario);
        this.bono = bono;
        this.nivel = nivel;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
