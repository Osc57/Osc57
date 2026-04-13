package org.example.ControladorDAO;

import org.example.Modelo.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnection;

public class EmpleadosDAO {

    public EmpleadosDAO() {

    }

    public static boolean insertarEmpleado(Empleados empleados) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO empleados (dni,nombre,apellidos,email,salario,id_depa) VALUES (?,?,?,?,?,?)")) {

            ps.setString(1, empleados.getDni());
            ps.setString(2, empleados.getNombre());
            ps.setString(3, empleados.getApellidos());
            ps.setString(4, empleados.getEmail());
            ps.setDouble(5, empleados.getSalario());
            ps.setInt(6, empleados.getDepartamento());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static boolean eliminarEmpleado(Empleados empleados) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("DELETE FROM empleados WHERE dni = ?")) {

            ps.setString(1, empleados.getDni());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
