package org.iesch.bbdd;

import org.iesch.persona.Alumno;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseCRUD {
    private final String url = "jdbc:mysql://localhost:3306/alumnos";
    private final String user = "root";
    private final String password = "1234";
    public Connection connect() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public int inserta(Alumno alumno){
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO alumno(id,nombre, apellidos, direccion)" +
                            "VALUES (?,?,?,?)");
            preparedStatement.setInt(1, alumno.getId());
            preparedStatement.setString(2, alumno.getNombre());
            preparedStatement.setString(3, alumno.getApellidos());
            preparedStatement.setString(4, alumno.getDireccion());


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
