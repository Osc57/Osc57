package Ap2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Empleado> listaEmpleados = new ArrayList<>();

        listaEmpleados.add(new EmpleadoFijo("Ana García", 2500.0));
        listaEmpleados.add(new EmpleadoPorHoras("Luis Pérez", 40, 20.0));
        listaEmpleados.add(new EmpleadoFijo("Carlos Ruiz", 1800.0));
        listaEmpleados.add(new EmpleadoPorHoras("María López", 20, 25.0));

        double salarioTotal = 0;

        System.out.println("Detalle de Nómina:");
        for (Empleado e : listaEmpleados) {
            double sueldo = e.calcularSalario();
            salarioTotal = salarioTotal + sueldo;
            System.out.println("Nombre: " + e.getNombre() + " | Salario: " + sueldo + "€");
        }

        System.out.println("Salario total de los empleados: " + salarioTotal + "€");
    }
}
