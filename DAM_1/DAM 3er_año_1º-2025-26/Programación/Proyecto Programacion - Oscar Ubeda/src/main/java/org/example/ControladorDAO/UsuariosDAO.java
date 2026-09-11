package org.example.ControladorDAO;

import org.example.Modelo.Gerente;
import org.example.Modelo.Programador;
import org.example.Modelo.Usuarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class UsuariosDAO {

    public UsuariosDAO() {
    }

    public static int combrobarUsuarios(Usuarios usuarios) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT usuario, password FROM usuarios WHERE usuario = ?")) {

            ps.setString(1, usuarios.getUsuario());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                return 0;
            }

            String password = rs.getString("password");

            if (password.equals(usuarios.getPassword())) {
                return 1;
            }

            return 2;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean comprobarUsuarioEmpleado(Usuarios usuarios) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE dni = ?")) {

            ps.setString(1, usuarios.getDni());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarNombreUsuarioEmpleado(Usuarios usuarios) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) FROM usuarios WHERE usuario = ?")) {

            ps.setString(1, usuarios.getUsuario());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si el conteo es mayor a 0, el usuario ya existe
                    return rs.getInt(1) > 0;
                }
            }
            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarExistenciaUsuario(Usuarios usuarios) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT dni FROM usuarios WHERE dni = ?")) {

            ps.setString(1, usuarios.getDni());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean insertarUsuarios(Usuarios usuarios) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO usuarios (usuario, password, dni) VALUES (?,?,?)")) {

            ps.setString(1, usuarios.getUsuario());
            ps.setString(2, usuarios.getPassword());
            ps.setString(3, usuarios.getDni());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }

    public static boolean esGerente(Usuarios usuario) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT dni FROM gerentes WHERE dni = ?")) {
            ps.setString(1, usuario.getDni());
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Si existe → es gerente
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Gerente obtenerGerente(Usuarios usuario) {
        String sql = "SELECT e.dni, e.nombre, e.apellidos, e.email, e.telefono, e.salario, e.id_depa, g.bono, g.nivel FROM empleados e JOIN gerentes g ON e.dni = g.dni WHERE e.dni = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getDni());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Gerente(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDouble("salario"),
                        rs.getInt("id_depa"),
                        rs.getDouble("bono"),
                        rs.getString("nivel")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static Usuarios obtenerUsuarioPorNombre(Usuarios usuario) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, usuario.getUsuario());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuarios(
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getString("dni")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static Programador obtenerProgramador(Usuarios usuario) {
        String sql = "SELECT e.dni, e.nombre, e.apellidos, e.email, e.telefono, e.salario, e.id_depa, p.lenguajePrincipal FROM empleados e JOIN programadores p ON e.dni = p.dni WHERE e.dni = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, usuario.getDni());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Programador(
                        rs.getString("dni"),
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDouble("salario"),
                        rs.getInt("id_depa"),
                        rs.getString("lenguajePrincipal")
                );
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
