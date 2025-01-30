package Ej5;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Agustin", "micontraseña123");

        System.out.println(usuario1.verificarContrasena("micontraseña123"));
        usuario1.cambiarContrasena("MiContraseña123");
        System.out.println(usuario1.verificarContrasena("micontraseña123"));
        System.out.println(usuario1.verificarContrasena("MiContraseña123"));

    }
}
