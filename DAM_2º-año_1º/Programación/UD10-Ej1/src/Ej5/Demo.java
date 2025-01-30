package Ej5;

public class Demo {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Agustin", "micontraseña123");

        System.out.println(usuario1.verificarContrasena("micontraseña123"));
        usuario1.cambiarContrasena("MiContraseña123");
        System.out.println(usuario1.verificarContrasena("micontraseña123"));
        System.out.println(usuario1.verificarContrasena("MiContraseña123"));

    }
}
