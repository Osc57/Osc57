package org.example.ControladorDAO;

import org.example.Modelo.Departamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class DepartamentoDAO {
    public DepartamentoDAO() {

    }

    public static boolean insertarDepartamento(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO departamentos (nombre, ubicacion) VALUES (?,?)")) {

            ps.setString(1, departamento.getNombre());
            ps.setString(2, departamento.getUbicacion());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean eliminarDepartamentos(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM departamentos WHERE id = ?")) {

            ps.setInt(1, departamento.getId());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Departamento> obtenerDepartamentos() {
        ArrayList<Departamento> departamentos = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT id, nombre FROM departamentos");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Departamento departamento = new Departamento();

                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));

                departamentos.add(departamento);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departamentos;
    }

    public static Departamento mostrarNombreDepartamento(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT nombre FROM departamentos WHERE id = ?")) {

            ps.setInt(1, departamento.getId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                departamento.setNombre(rs.getString("nombre"));
            } else {
                departamento.setNombre(null);
            }

            return departamento;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean departamentoEnPiso(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM departamentos WHERE nombre = ? AND ubicacion <> ?")) {

            ps.setString(1, departamento.getNombre());
            ps.setString(2, departamento.getUbicacion());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean existeNombreDepartamento(Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM departamentos WHERE nombre = ?")) {

            ps.setString(1, departamento.getNombre());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
