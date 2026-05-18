package org.example.Modelo;

public class Gerente extends Empleados {
    private String dni;
    private double bono;
    private String nivel;

    public Gerente() {
    }

    public Gerente(String dni, double bono, String nivel) {
        this.dni = dni;
        this.bono = bono;
        this.nivel = nivel;
    }

    public Gerente(double bono, String nivel) {
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

    @Override
    public String toString() {
        return super.toString();
    }
}
