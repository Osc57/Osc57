package org.example.ControladorDAO;

import org.example.Modelo.Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class ProyectosDAO {

    public ProyectosDAO() {

    }

    public static boolean insertarProyecto(Proyecto proyecto) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO proyectos (nombre,presupuesto,fechaInicio,finalizado) VALUES (?,?,?,?)")) {

            ps.setString(1, proyecto.getNombre());
            ps.setDouble(2, proyecto.getPresupuesto());

            ps.setDate(3, new java.sql.Date(proyecto.getFechaInicio().getTime()));

            ps.setBoolean(4, proyecto.getFinalizado());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
