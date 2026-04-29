package org.example.ControladorDAO;

import org.example.Modelo.Empleados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.example.Configuracion.Conexion.getConnection;

public class EmpleadosDAO {

    public EmpleadosDAO() {

    }

    public static ArrayList<Empleados> mostrarEmpleados() {
        ArrayList<Empleados> listaEmpelados = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM empleados")) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Empleados empleados = new Empleados();
                empleados.setDni(resultSet.getString("dni"));
                empleados.setNombre(resultSet.getString("nombre"));
                empleados.setApellidos(resultSet.getString("apellidos"));
                empleados.setEmail(resultSet.getString("email"));
                empleados.setSalario(resultSet.getDouble("salario"));
                empleados.setDepartamento(resultSet.getInt("id_depa"));

                listaEmpelados.add(empleados);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEmpelados;
    }

    public static boolean insertarEmpleado(Empleados empleados) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO empleados (dni,nombre,apellidos,email,salario,id_depa,telefono) VALUES (?,?,?,?,?,?,?)")) {

            ps.setString(1, empleados.getDni());
            ps.setString(2, empleados.getNombre());
            ps.setString(3, empleados.getApellidos());
            ps.setString(4, empleados.getEmail());
            ps.setDouble(5, empleados.getSalario());
            ps.setInt(6, empleados.getDepartamento());
            ps.setString(7, empleados.getTelefono());

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

    public static boolean comprobarEmpleados(Empleados empleado) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE dni = ?")) {

            ps.setString(1, empleado.getDni());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean seleccionarGerenteEmpleado(Empleados empleados) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM gerentes WHERE dni = ?")) {

            ps.setString(1, empleados.getDni());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean emailExistente(Empleados empleados) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE email = ?")) {

            ps.setString(1, empleados.getEmail());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Empleados obtenerDatosEmpelado(Empleados empleado) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT nombre, apellidos, salario, telefono, id_depa FROM empleados WHERE dni = ?")) {

            ps.setString(1, empleado.getDni());

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellidos(rs.getString("apellidos"));
                empleado.setSalario(rs.getDouble("salario"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setDepartamento(rs.getInt("id_depa"));
            }

            return empleado;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean modificarDatosEmpleado(Empleados empleados) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE empleados SET nombre = ?, apellidos = ?, telefono = ?, email = ?, salario = ? WHERE dni = ?")) {

            ps.setString(1, empleados.getNombre());
            ps.setString(2, empleados.getApellidos());
            ps.setString(3, empleados.getTelefono());
            ps.setString(4, empleados.getEmail());
            ps.setDouble(5, empleados.getSalario());
            ps.setString(6, empleados.getDni());

            int filasAfect = ps.executeUpdate();

            return filasAfect > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
