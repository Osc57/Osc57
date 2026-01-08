package Ap2;

public class EmpleadoFijo extends Empleado {
    public EmpleadoFijo(String nombre, double salarioMensual) {
        super(nombre);
        this.salario = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salario;
    }
}
