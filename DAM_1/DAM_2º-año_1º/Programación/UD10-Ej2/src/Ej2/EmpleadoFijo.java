package Ej2;

public class EmpleadoFijo extends Empleado{

    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }

    @Override
    public String mostrarInfo() {
        return super.mostrarInfo()+ "Fijo: " + nombre + ", Salario: " + salario;
    }
}



