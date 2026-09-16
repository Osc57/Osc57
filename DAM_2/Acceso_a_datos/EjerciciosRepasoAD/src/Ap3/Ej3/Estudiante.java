package Ap3.Ej3;

public class Estudiante {
    private String nombre;
    private int edad;
    private String grado;

    public Estudiante() {
    }

    public Estudiante(String nombre, int edad, String grado) {
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " - Edad: " + edad + " - Grado: " + grado + "\n";
    }
}
