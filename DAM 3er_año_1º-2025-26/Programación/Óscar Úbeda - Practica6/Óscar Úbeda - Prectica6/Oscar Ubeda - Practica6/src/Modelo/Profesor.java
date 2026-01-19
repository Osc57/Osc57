package Modelo;

import java.time.LocalDate;

public class Profesor extends Trabajador {
    private String especialidad;
    private int horasLectivasSemanales;

    public Profesor(String nombre, String apellidos, String dni, LocalDate fechaDeIncorporacion, double salarioBase, String especialidad, int horasLectivasSemanales) {
        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.especialidad = especialidad;
        this.horasLectivasSemanales = horasLectivasSemanales;
    }


    @Override
    public double calcularSalario() {
        return super.getSalarioBase() + (super.getSalarioBase() * horasLectivasSemanales);
    }

    @Override
    public String trabajar() {
        return super.trabajar() + " en la especialidad de " + especialidad;
    }
}
