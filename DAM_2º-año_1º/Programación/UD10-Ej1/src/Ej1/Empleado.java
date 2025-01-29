package Ej1;

public class Empleado {
    private String nombre;
    private double salarioBase;

    //Genero los constructores para la clase empleado
    public Empleado() {
    }

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    //Me creo el metodo de mostrar info
    public String mostrarInfo() {
        return "Nombre: " +nombre+ ", Salario: " + salarioBase;
    }
}
