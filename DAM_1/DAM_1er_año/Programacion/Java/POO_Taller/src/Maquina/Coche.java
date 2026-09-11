package Maquina;

public class Coche extends Vehiculo{
    private int anchura;
    private int altura;

    public Coche(String matricula) throws Exception {
        super(matricula);
    }

    public int getAnchura() {
        return anchura;
    }

    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public String identificate(){
        return "Soy un coche, mi matricula es " +  super.getMatricula();
    }
}
