package Figuras;

public class Rectangulo extends Figura{
    private float lado;
    private float altura;
    public Rectangulo(String nombre) {
        super(nombre);
    }

    public float perimetro(){
        return (float) ((2 * this.lado)  + (2 * this.altura));
    }

    public float area (){
        return (float) (this.lado * this.altura) ;
    }

    public Rectangulo(String nombre, float lado, float altura) {
        super(nombre);
        this.lado = lado;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Rectangulo{" +
                "lado=" + lado +
                ", altura=" + altura +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
