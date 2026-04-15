package org.example.Utils;

public class RegistroValidator {

    public static boolean camposRellenos(String... campos) {
        for (String c : campos) {
            if (c == null || c.isBlank()) {
                return false;
            }
        }
        return true;
    }

    public static boolean dniValido(String dni) {
        return dni.matches("^[0-9]{8}[A-Za-z]$");
    }

    public static boolean usuarioValido(String usuario) {
        return usuario.matches("^[a-zA-Z0-9_]{4,12}$");
    }

    public static boolean passwordValida(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*[^a-zA-Z]).{12,}$");
    }

    public static boolean passwordsCoinciden(String p1, String p2) {
        return p1.equals(p2);
    }
}
