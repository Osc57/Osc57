package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Programador;
import org.example.Modelo.Proyecto;

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

    public static Programador obtenerLenguajeProgramador(Empleados empleados) {
        Programador programador = new Programador();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT lenguajePrincipal FROM programadores WHERE dni = ?")) {

            ps.setString(1, empleados.getDni());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                programador.setLenguajePrincipal(rs.getString("lenguajePrincipal"));
            }

            return programador;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean modificarDatosProgramador(Empleados empleados, Programador programador) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE programadores SET lenguajePrincipal = ? WHERE dni = ?")) {

            ps.setString(1, programador.getLenguajePrincipal());
            ps.setString(2, empleados.getDni());

            int filasAfect = ps.executeUpdate();

            return filasAfect > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean asignarProgramadorProyecto(Programador empleados, Proyecto proyecto) {
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

    public static ArrayList<Programador> obtenerEmpleadosLibres() {
        ArrayList<Programador> listaLibres = new ArrayList<>();


        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT e.* FROM empleados e WHERE e.dni NOT IN (SELECT DISTINCT t.dni FROM trabaja t JOIN proyectos p ON t.id_proyect = p.id WHERE p.fechaInicio <= CURDATE() AND p.finalizado = 0)");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                // Mapeas el registro de la BBDD a tu objeto de Java
                Programador p = new Programador();
                p.setDni(rs.getString("dni"));
                p.setNombre(rs.getString("nombre"));
                p.setApellidos(rs.getString("apellidos"));
                // ... setea aquí el resto de atributos de tu objeto ...

                listaLibres.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaLibres; // Devuelve la colección de objetos
    }

    public static boolean saberSiProgramdaroEstaEnProyecto(Programador programador) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM trabaja WHERE dni = ?")) {

            ps.setString(1, programador.getDni());

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean programadorTieneAsignaciones(Programador programador) {
        String sql = "SELECT COUNT(*) FROM trabaja WHERE dni = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, programador.getDni());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // Tiene asignaciones
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false; // No tiene asignaciones
    }

}
