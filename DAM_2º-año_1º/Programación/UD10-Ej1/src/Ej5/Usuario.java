package Ej5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario {
    private String nombreUsuario;
    public String contrasena;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public boolean verificarContrasena (String ingreso){
        if (contrasena.equals(ingreso)){
            return true;
        }else {
            return false;
        }
    }

    public void cambiarContrasena (String nuevaContrasena){
        String regexPass = "\\b[A-Z]\\w[0-9].{8,}\\b";
        Pattern patternPass = Pattern.compile(regexPass);
        Matcher matcherPass = patternPass.matcher(nuevaContrasena);
    }


}
