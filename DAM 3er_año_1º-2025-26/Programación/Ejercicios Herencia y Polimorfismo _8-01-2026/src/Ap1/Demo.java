package Ap1;

public class Demo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal gato = new Gato();
        Animal perro = new Perro();

        System.out.println(animal.hacerSonido());
        System.out.println(gato.hacerSonido());
        System.out.println(perro.hacerSonido());
    }
}
