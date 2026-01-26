package Ej1;

public class Demo {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Augusto", 1500);
        Gerente gerente = new Gerente("Bianca", 1950, 45);

        System.out.println(empleado.mostrarInfo());
        System.out.println(gerente.mostrarInfo());
    }
}
