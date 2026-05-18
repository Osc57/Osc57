package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class GerenteDAO {

    public GerenteDAO() {

    }

    public static ArrayList<Gerente> mostrarGerentes() {
        ArrayList<Gerente> listaGerentes = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT e.*, g.bono, g.nivel FROM empleados e JOIN gerentes g ON e.dni = g.dni")) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Gerente gerente = new Gerente();
                gerente.setDni(resultSet.getString("dni"));
                gerente.setNombre(resultSet.getString("nombre"));
                gerente.setApellidos(resultSet.getString("apellidos"));
                gerente.setEmail(resultSet.getString("email"));
                gerente.setSalario(resultSet.getDouble("salario"));
                gerente.setDepartamento(resultSet.getInt("id_depa"));
                gerente.setBono(resultSet.getDouble("bono"));
                gerente.setNivel(resultSet.getString("nivel"));

                listaGerentes.add(gerente);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaGerentes;
    }

    public static boolean insertarGerente(Empleados empelados, Gerente gerente) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO gerentes (dni,bono,nivel) VALUES (?,?,?)")) {

            ps.setString(1, empelados.getDni());
            ps.setDouble(2, gerente.getBono());
            ps.setString(3, gerente.getNivel());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Gerente obtenerNivelGerente(Empleados empleados) {
        Gerente gerente = new Gerente();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT nivel FROM gerentes WHERE dni = ?")) {

            ps.setString(1, empleados.getDni());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                gerente.setNivel(rs.getString("nivel"));
            }

            return gerente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean modificarDatosGerente(Empleados empleados, Gerente gerente) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE gerentes SET bono = ?, nivel = ? WHERE dni = ?")) {

            ps.setDouble(1, gerente.getBono());
            ps.setString(2, gerente.getNivel());
            ps.setString(3, empleados.getDni());

            int filasAfect = ps.executeUpdate();

            return filasAfect > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean asignarGerenteProyecto(Gerente empleados, Proyecto proyecto) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO trabaja (dni,id_proyect) VALUES (?,?)")) {

            ps.setString(1, empleados.getDni());
            ps.setInt(2, proyecto.getId());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Gerente obtenerDatosGerente(Gerente gerente) {
        String sql = "SELECT e.*, g.bono, g.nivel FROM empleados e JOIN gerentes g ON e.dni = g.dni WHERE e.dni = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, gerente.getDni());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Datos heredados de la clase Empleados
                    gerente.setNombre(rs.getString("nombre"));
                    gerente.setApellidos(rs.getString("apellidos"));
                    gerente.setSalario(rs.getDouble("salario"));
                    gerente.setTelefono(rs.getString("telefono"));
                    gerente.setDepartamento(rs.getInt("id_depa"));

                    // 2. ¡Faltaba esto! Datos exclusivos de la clase Gerente
                    gerente.setBono(rs.getDouble("bono"));
                    gerente.setNivel(rs.getString("nivel"));
                }
            }

            return gerente;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Gerente> obtenerGerentesLibres() {
        ArrayList<Gerente> listaGerentes = new ArrayList<>();
        String sql = "SELECT e.*, g.bono, g.nivel FROM empleados e JOIN gerentes g ON e.dni = g.dni WHERE e.dni NOT IN (SELECT DISTINCT t.dni FROM trabaja t JOIN proyectos p ON t.id_proyect = p.id WHERE p.fechaInicio <= CURDATE() AND p.finalizado = 0)";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Gerente g = new Gerente();
                // Datos de la tabla 'empleados' (Heredados)
                g.setDni(rs.getString("dni"));
                g.setNombre(rs.getString("nombre"));
                g.setApellidos(rs.getString("apellidos"));
                g.setSalario(rs.getDouble("salario"));
                g.setTelefono(rs.getString("telefono"));
                g.setDepartamento(rs.getInt("id_depa"));

                // Datos de la tabla 'gerentes' (Propios)
                g.setBono(rs.getDouble("bono"));
                g.setNivel(rs.getString("nivel"));

                listaGerentes.add(g);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaGerentes;
    }
}
