package POO.src.TallerÓscarÚbeda;

class Coches extends Vehiculos{
    double anchura;
    double altura;


    public Coches(String matricula, String marca, String modelo) {
        super(matricula, marca, modelo);
    }

    public Coches(String matricula, String marca, String modelo, double anchura, double altura) {
        super(matricula, marca, modelo);
        this.anchura = anchura;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Coches{" +
                "anchura=" + anchura +
                ", altura=" + altura +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
