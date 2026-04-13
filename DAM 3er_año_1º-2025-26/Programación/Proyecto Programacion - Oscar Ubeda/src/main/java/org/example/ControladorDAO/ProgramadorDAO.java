package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class ProgramadorDAO {

    public ProgramadorDAO() {

    }

    public static ArrayList<Programador> mostrarProgramadores() {
        ArrayList<Programador> listaProgramadores = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT e.* , p.lenguajePrincipal FROM empleados e JOIN programadores P ON e.dni = p.dni")) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Programador programador = new Programador();
                programador.setDni(resultSet.getString("dni"));
                programador.setNombre(resultSet.getString("nombre"));
                programador.setApellidos(resultSet.getString("apellidos"));
                programador.setEmail(resultSet.getString("email"));
                programador.setSalario(resultSet.getDouble("salario"));
                programador.setDepartamento(resultSet.getInt("id_depa"));
                programador.setLenguajePrincipal(resultSet.getString("lenguajePrincipal"));

                listaProgramadores.add(programador);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaProgramadores;
    }

    public static boolean insertarProgramador(Empleados empelados, Programador programador) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO programadores (dni, lenguajePrincipal) VALUES (?,?)")) {

            ps.setString(1, empelados.getDni());
            ps.setString(2, programador.getLenguajePrincipal());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
