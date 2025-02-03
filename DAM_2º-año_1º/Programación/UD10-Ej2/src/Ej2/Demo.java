package Ej2;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<Empleado> empleados = new ArrayList<>();

        empleados.add(new EmpleadoFijo("Manuel",1750));
        empleados.add(new EmpleadoFijo("Alberto",1600));
        empleados.add(new EmpleadoPorHoras("Xavier",1450,20,15));
        empleados.add(new EmpleadoPorHoras("Jaime",1320,10,20));

        double salarioTotal = 0;

        for (Empleado e : empleados){
            double salario = e.calcularSalario();
            System.out.println(e + ", Salario: " + salario);
            salarioTotal = salarioTotal + salario;
        }

        System.out.println("Salario Total: " + salarioTotal);

    }
}
