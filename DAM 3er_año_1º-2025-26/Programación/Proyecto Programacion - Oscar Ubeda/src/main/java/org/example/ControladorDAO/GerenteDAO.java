package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;

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
}
