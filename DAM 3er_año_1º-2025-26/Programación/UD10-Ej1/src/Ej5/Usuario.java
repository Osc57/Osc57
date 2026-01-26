package Ej5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private String nombreUsuario;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean verificarContrasena(String ingreso) {
        return this.contrasena.equals(ingreso);
    }

    public String cambiarContrasena(String nuevaContrasena) {
        String regexPass = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern patternPass = Pattern.compile(regexPass);
        Matcher matcherPass = patternPass.matcher(nuevaContrasena);

        if (matcherPass.matches()) {
            contrasena = nuevaContrasena;
            return ("La contraseña es valida, se cambiara la contraseña");
        } else {
            return ("No se ha podido cambiar la contraseña");
        }
    }

    public String mostrarDatos() {//Metodo creado por mí para saber si se cumplen los cambios
        return "El usuario " + nombreUsuario + " tiene la contraseña " + contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
