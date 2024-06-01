package Ej6;

public class Conejo extends Animal implements Herbivoro{
    @Override
    public Object comunicarse() {
        System.out.println("El conejo hace ruido...");
        return null;
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
