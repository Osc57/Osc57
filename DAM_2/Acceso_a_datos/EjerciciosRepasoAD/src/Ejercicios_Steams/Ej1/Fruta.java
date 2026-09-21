package Ejercicios_Steams.Ej1;

public class Fruta {
    private String nombre;
    private String color;

    public Fruta(String nombre, String color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fruta -> " + nombre + ", " + color;
    }
}
