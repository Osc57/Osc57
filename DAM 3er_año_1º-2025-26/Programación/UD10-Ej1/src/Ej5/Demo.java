package Ej5;

public class Demo {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Pacheco12", "miIncreibleContraseña123");

        System.out.println(usuario.mostrarDatos());
        System.out.println(usuario.verificarContrasena("miIncreibleContraseña123"));
        System.out.println("-----------------------------------------------------");
        System.out.println(usuario.cambiarContrasena("miSuperNuevaIncreibleContraseña123"));
        System.out.println("-----------------------------------------------------");
        System.out.println(usuario.mostrarDatos());
    }
}
