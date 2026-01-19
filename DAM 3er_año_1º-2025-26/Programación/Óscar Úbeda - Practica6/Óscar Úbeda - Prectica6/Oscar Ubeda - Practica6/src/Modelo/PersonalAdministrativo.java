package Modelo;

import java.time.LocalDate;

public class PersonalAdministrativo extends Trabajador {
    private String departamento;
    private int nivel;

    public PersonalAdministrativo(String nombre, String apellidos, String dni, LocalDate fechaDeIncorporacion, double salarioBase, String departamento, int nivel) {
        super(nombre, apellidos, dni, fechaDeIncorporacion, salarioBase);
        this.departamento = departamento;
        this.nivel = nivel;
    }
    //Nivel por complemento + salario base
    @Override
    public double calcularSalario() {
        return super.getSalarioBase();
    }

    @Override
    public String trabajar() {
        return super.trabajar() + " y realizo labores administrativas en el departamento de " + departamento;
    }
}
