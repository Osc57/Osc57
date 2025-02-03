package Ej2;

public class EmpleadoFijo extends Empleado{

    public EmpleadoFijo(String nombre, double salario) {
        super(nombre, salario);
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}



