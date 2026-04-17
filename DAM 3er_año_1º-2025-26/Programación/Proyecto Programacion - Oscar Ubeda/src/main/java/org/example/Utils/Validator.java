package org.example.Utils;

public class Validator {

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

    public static boolean nombreValido(String nombre) {
        return nombre.matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$");
    }

    public static boolean apellidosValido(String apellido) {
        return apellido.matches("^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?: [A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)?$");
    }

    public static boolean telefonoValido(String telefono) {
        return telefono.matches("^[0-9]{9}");
    }

    public static boolean validarEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }
}
