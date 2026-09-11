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
        String regexPass = "^(?=.*[A-Z])(?=.*\\d).{8,}$";
        Pattern patternPass = Pattern.compile(regexPass);
        Matcher matcherPass = patternPass.matcher(nuevaContrasena);

        if (matcherPass.matches()){
            System.out.println("La contraseña es valida, se cambiara la contraseña");
            contrasena = nuevaContrasena;
        }else {
            System.out.println("No se ha podido cambiar la contraseña");
        }
    }


}
