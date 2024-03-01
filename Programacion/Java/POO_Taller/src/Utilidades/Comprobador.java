package Utilidades;

public class Comprobador {
    public static  boolean esValidaLaMatricula(String matricula){
        if (matricula == null){
            return false;
        }
        return 7 == matricula.length();
    }
    public static boolean esValidoDNI(String dni){
        if (dni == null){
            return false;
        }
        return 9 == dni.length();
    }
}
