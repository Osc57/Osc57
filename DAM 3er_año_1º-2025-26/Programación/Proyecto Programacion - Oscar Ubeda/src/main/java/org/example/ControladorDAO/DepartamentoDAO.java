package org.example.ControladorDAO;

import org.example.Modelo.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class DepartamentoDAO {
    public DepartamentoDAO() {

    }

    public static boolean insertarDepartamento(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO departamentos (nombre, ubicacion) VALUES (?,?)")) {

            ps.executeUpdate(departamento.getNombre());
            ps.executeUpdate(departamento.getUbicacion());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
