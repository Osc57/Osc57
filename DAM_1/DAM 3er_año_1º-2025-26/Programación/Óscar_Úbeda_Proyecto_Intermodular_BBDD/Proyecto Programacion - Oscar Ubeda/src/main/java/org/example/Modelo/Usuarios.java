package org.example.Modelo;

public class Usuarios {
    private int id;
    private String usuario;
    private String password;
    private String dni;

    public Usuarios(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    public Usuarios(String usuario, String password, String dni) {
        this.usuario = usuario;
        this.password = password;
        this.dni = dni;
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

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
