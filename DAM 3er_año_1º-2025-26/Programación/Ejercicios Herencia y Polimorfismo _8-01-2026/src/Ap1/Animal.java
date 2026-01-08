package Ap1;

public class Animal {
    protected String sonido;

    public Animal(String sonido) {
        this.sonido = sonido;
    }

    public String hacerSonido(){
        return sonido;
    }
}
