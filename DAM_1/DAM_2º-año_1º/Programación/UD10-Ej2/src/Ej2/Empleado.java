package Ej2;

public abstract class Empleado {
    protected String nombre;
    protected double salario;

    public abstract double calcularSalario();

    public Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String mostrarInfo(){
        return "Empleado ";
    }
}
