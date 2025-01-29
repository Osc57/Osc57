package Ej1;

public class Demo {
    public static void main(String[] args) {
        //Me creo los objetos de las clases en el demo
        Empleado empleado1 = new Empleado("Eduardo", 1750);
        System.out.println(empleado1.mostrarInfo());

        Gerente gerente1 = new Gerente("Mariano", 1750, 120);
        System.out.println(gerente1.mostrarInfo());
    }
}
