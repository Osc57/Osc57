package Ap1;

public class Demo {
    public static void main(String[] args) {
        Animal gato = new Gato();
        Animal perro = new Perro();

        System.out.println(gato.hacerSonido());
        System.out.println(perro.hacerSonido());
    }
}
