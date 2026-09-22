package Ejercicios_Streams.Ej5;

public class Empleado {
    private String nombre;
    private String departamento;

    public Empleado(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return nombre + " " + departamento;
    }
}
