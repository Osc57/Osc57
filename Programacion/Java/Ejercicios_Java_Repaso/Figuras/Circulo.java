package Figuras;

public class Circulo extends Figura{
    private float radio;

    public Circulo(String nombre) {
        super(nombre);
    }
    public float perimetro(){
        return (float) (2 * Math.PI * radio);
    }

    public float area (){
        return (float) Math.PI * radio * radio;
    }

    public Circulo(String nombre, float radio) {
        super(nombre);
        this.radio = radio;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "radio=" + radio +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
