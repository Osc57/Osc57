package org.example.ControladorDAO;

import org.example.Modelo.Proyecto;

import java.sql.*;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class ProyectosDAO {

    public ProyectosDAO() {

    }

    public static boolean insertarProyecto(Proyecto proyecto) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO proyectos (nombre,presupuesto,fechaInicio,finalizado,tipo) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, proyecto.getNombre());
            ps.setDouble(2, proyecto.getPresupuesto());

            ps.setDate(3, new java.sql.Date(proyecto.getFechaInicio().getTime()));

            ps.setBoolean(4, proyecto.getFinalizado());
            ps.setString(5, proyecto.getTipo());

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

    public static boolean comprobarNombreProyecto(Proyecto proyecto) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM proyectos WHERE nombre = ?")) {

            ps.setString(1, proyecto.getNombre());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Proyecto> mostrarProyectosSinFinalizar() {
        ArrayList<Proyecto> listaProyectos = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM proyectos WHERE finalizado = false");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proyecto proyecto = new Proyecto();

                proyecto.setId(rs.getInt("id"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setPresupuesto(rs.getDouble("presupuesto"));
                proyecto.setTipo(rs.getString("tipo"));
                proyecto.setFechaInicio(rs.getDate("fechaInicio"));
                proyecto.setFinalizado(rs.getBoolean("finalizado"));


                listaProyectos.add(proyecto);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaProyectos;
    }

    public static ArrayList<Proyecto> mostrarProyectosFinalizados() {
        ArrayList<Proyecto> listaProyectos = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM proyectos WHERE finalizado = true");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Proyecto proyecto = new Proyecto();

                proyecto.setId(rs.getInt("id"));
                proyecto.setNombre(rs.getString("nombre"));
                proyecto.setPresupuesto(rs.getDouble("presupuesto"));
                proyecto.setTipo(rs.getString("tipo"));
                proyecto.setFechaInicio(rs.getDate("fechaInicio"));
                proyecto.setFinalizado(rs.getBoolean("finalizado"));


                listaProyectos.add(proyecto);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaProyectos;
    }

    public static boolean finalizarProyecto(Proyecto proyecto) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE proyectos SET finalizado = true WHERE id = ?")) {

            ps.setInt(1, proyecto.getId());

            int filasActualizadas = ps.executeUpdate();

            return filasActualizadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarTrabajadoresProyecto(Proyecto proyecto) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM trabaja WHERE id_proyect = ?")) {

            ps.setInt(1, proyecto.getId());

            int filasEliminadas = ps.executeUpdate();

            return filasEliminadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static int contarTrabajadoresProyecto(Proyecto proyecto) {
        String sql = "SELECT COUNT(*) FROM trabaja WHERE id_proyect = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, proyecto.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }

    public static boolean actualizarProyecto(Proyecto proyecto) {

        String sql = "UPDATE proyectos SET nombre = ?, tipo = ?, presupuesto = ? WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getTipo());
            ps.setDouble(3, proyecto.getPresupuesto());
            ps.setInt(4, proyecto.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean estaFinalizado(Proyecto proyecto) {
        String sql = "SELECT finalizado FROM proyectos WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, proyecto.getId());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getBoolean("finalizado");
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static boolean actualizarProyectoSiFinalizado(Proyecto proyecto) {

        String sql = "UPDATE proyectos SET nombre = ?, tipo = ?, presupuesto = ?, finalizado = false WHERE id = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, proyecto.getNombre());
            ps.setString(2, proyecto.getTipo());
            ps.setDouble(3, proyecto.getPresupuesto());
            ps.setInt(4, proyecto.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
