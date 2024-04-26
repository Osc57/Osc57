package org.iesch.bbdd;

import org.iesch.modelos.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DatabaseCRUD {

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
                int dni = resultSet.getInt("dni");
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

                listaPersonas.add(p);
            }
            resultSet.close();
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return listaPersonas;
    }
    public int inserta(Persona persona){
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO persona(dni, nombre, apellidos, sexo, altura, peso)" +
                            "VALUES (?,?,?,?,?,?)");
            preparedStatement.setInt(1, persona.getDni());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellidos());
            preparedStatement.setString(4, persona.getSexo());
            preparedStatement.setInt(5, persona.getAltura());
            preparedStatement.setFloat(6, persona.getPeso());

            //Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }
    public int borra(Persona persona){
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM persona WHERE dni= ?");
            preparedStatement.setInt(1, persona.getDni());

            //Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }
    public int actualiza(Persona persona){
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE persona SET nombre = ?, apellidos=?, sexo=?, altura=?, peso=? WHERE dni= ?");

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getSexo());
            preparedStatement.setInt(4, persona.getAltura());
            preparedStatement.setFloat(5, persona.getPeso());
            preparedStatement.setInt(6, persona.getDni());

            //Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }

}
