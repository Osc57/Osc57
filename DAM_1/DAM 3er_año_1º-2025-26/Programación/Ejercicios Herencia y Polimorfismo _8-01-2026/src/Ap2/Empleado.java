package Ap2;

public class Empleado {
    protected String nombre;
    protected double salario;

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public double calcularSalario() {
        return salario;
    }

    public String getNombre() {
        return nombre;
    }
}
