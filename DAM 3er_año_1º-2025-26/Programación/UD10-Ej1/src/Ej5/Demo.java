package Ej5;

public class Demo {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Pacheco12", "miIncreibleContraseña123");

        System.out.println("Verificar contraseña 'miIncreibleContraseña123': " + usuario.verificarContrasena("miIncreibleContraseña123"));
        System.out.println("Verificar contraseña 'contraseñaIncreible123': " + usuario.verificarContrasena("contraseñaIncreible123"));
        System.out.println("-----------------------------------------------------");
        System.out.println("Cambiar contraseña");
        System.out.println(usuario.cambiarContrasena("miSuperIncreibleContraseña123"));

    }
}
