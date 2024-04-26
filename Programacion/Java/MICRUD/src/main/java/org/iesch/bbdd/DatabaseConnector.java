package org.iesch.bbdd;

import org.iesch.modelos.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseConnector {

    private final String url = "jdbc:mysql://localhost:3306/personas";
    private final String user = "root";
    private final String password = "1234";

    public Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Persona> obtenerTodo() {
        List<Persona> listaPersonas = new ArrayList<>();

        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM persona");

            while (resultSet.next()) {
                Persona p = new Persona();
                float peso = resultSet.getFloat("peso");
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String sexo = resultSet.getString("sexo");
                int altura = resultSet.getInt("altura");

                p.setPeso(peso);
                p.setDni(dni);
                p.setNombre(nombre);
                p.setApellidos(apellidos);
                p.setSexo(sexo);
                p.setAltura(altura);
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaPersonas;
    }
}
