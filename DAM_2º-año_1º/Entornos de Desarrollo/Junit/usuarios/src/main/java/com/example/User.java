package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que representa un usuario con validaciones básicas.
 */
public class User {
    private String nombre;
    private String correo;
    private int edad;

    public User(String name, String email, int age) {
        if (!esValidoUsuario(name)) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (!esValidoCorreo(email)) {
            throw new IllegalArgumentException("Correo inválido");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Edad fuera de rango");
        }
        this.nombre = name;
        this.correo = email;
        this.edad = age;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }

    private boolean esValidoUsuario(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[A-Za-z ]+");
    }

    private boolean esValidoCorreo(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(emailRegex, email);
    }
}

/**
 * Clase que gestiona una lista de usuarios.
 */
class UserManager {
    private List<User> users = new ArrayList<>();

    public void introducirUsuario(User user) {
        if (encontrarUsuarioCorreo(user.getCorreo()) != null) {
            throw new IllegalArgumentException("El usuario con este correo ya existe.");
        }
        users.add(user);
    }

    public User encontrarUsuarioCorreo(String email) {
        for (User user : users) {
            if (user.getCorreo().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public int obtenerTotalUsuarios() {
        return users.size();
    }
}