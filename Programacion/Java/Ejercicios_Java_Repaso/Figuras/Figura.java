package Figuras;

public class Figura {
    String nombre;

    public float area (){
        return 0;
    }
    public float perimetro(){
        return 0;
    }

    public Figura(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Figura{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
