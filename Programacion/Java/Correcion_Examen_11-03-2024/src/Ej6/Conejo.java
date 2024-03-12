package Ej6;

public class Conejo extends Animal implements Herbivoro{
    @Override
    public void comunicarse() {
        System.out.println("El conejo hace ruido...");
    }

    @Override
    public void dieta() {
        System.out.println("Como hierba");
    }

    @Override
    public void pastar() {
        System.out.println("Como hierba");
    }
}
