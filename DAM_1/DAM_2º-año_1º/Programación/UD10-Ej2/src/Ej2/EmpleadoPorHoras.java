package Ej2;

public class EmpleadoPorHoras extends Empleado{

    private int horasTrabajadas;
    private double tarifaPorHoras;

    public EmpleadoPorHoras(String nombre, double salario, int horasTrabajadas, double tarifaPorHoras) {
        super(nombre, salario);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHoras = tarifaPorHoras;
    }

    @Override
    public double calcularSalario() {
        return salario+(horasTrabajadas*tarifaPorHoras);
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + "Por Horas: " + nombre + ", Salario: " + salario + ", Plus: " + horasTrabajadas*tarifaPorHoras;
    }
}
