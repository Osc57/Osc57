package org.example.Modelo;

public class Usuarios {
    private int id;
    private String usuario;
    private String password;

    public Usuarios(String nombre, String password) {
        this.usuario = nombre;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setNombre(String nombre) {
        this.usuario = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
