package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

import java.sql.*;

import static org.example.Configuracion.Conexion.getConnection;

public class ProyectosDAO {

    public ProyectosDAO() {

    }

    public static boolean insertarProyecto(Proyecto proyecto) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO proyectos (nombre,presupuesto,fechaInicio,finalizado) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, proyecto.getNombre());
            ps.setDouble(2, proyecto.getPresupuesto());

            ps.setDate(3, new java.sql.Date(proyecto.getFechaInicio().getTime()));

            ps.setBoolean(4, proyecto.getFinalizado());

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                // 2. Obtenemos el ID autoincremental que asignó la BBDD
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idGenerado = rs.getInt(1);

                        // 3. ¡ESTA ES LA LÍNEA CLAVE! Guardamos el ID real en el objeto
                        proyecto.setId(idGenerado);
                    }
                }
                return true;
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
