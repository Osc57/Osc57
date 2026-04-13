package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Controlador.Conexion.getConnect;

public class ProgramadorDAO {

    public ProgramadorDAO() {

    }

    public static boolean insertarProgramador(Empleados empelados, Programador programador) {
        try (Connection connection = getConnect();
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
