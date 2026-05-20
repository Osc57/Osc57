package org.example.ControladorDAO;

import org.example.Modelo.Departamento;
import org.example.Modelo.Empleados;
import org.example.Modelo.Proyecto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.example.Configuracion.Conexion.getConnection;

public class EmpleadosDAO {

    public EmpleadosDAO() {

    }

    public static ArrayList<Empleados> mostrarEmpleados() {
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

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

                listaEmpleados.add(empleados);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaEmpleados;
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
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE email = ? AND dni <> ?")) {

            ps.setString(1, empleados.getEmail());
            ps.setString(2, empleados.getDni());

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Empleados obtenerDatosEmpelado(Empleados empleados) {

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT nombre, apellidos, salario, telefono, id_depa FROM empleados WHERE dni = ?")) {


            ps.setString(1, empleados.getDni());

            // 3. El ResultSet debe obtenerse DESPUÉS de asignar el parámetro
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    empleados.setNombre(rs.getString("nombre"));
                    empleados.setApellidos(rs.getString("apellidos"));
                    empleados.setSalario(rs.getDouble("salario"));
                    empleados.setTelefono(rs.getString("telefono"));
                    empleados.setDepartamento(rs.getInt("id_depa"));
                }
            }

            return empleados;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean modificarDatosEmpleado(Empleados empleados) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE empleados SET nombre = ?, apellidos = ?, telefono = ?, email = ?, salario = ?, id_depa = ? WHERE dni = ?")) {

            ps.setString(1, empleados.getNombre());
            ps.setString(2, empleados.getApellidos());
            ps.setString(3, empleados.getTelefono());
            ps.setString(4, empleados.getEmail());
            ps.setDouble(5, empleados.getSalario());
            ps.setInt(6, empleados.getDepartamento());
            ps.setString(7, empleados.getDni());

            int filasAfect = ps.executeUpdate();

            return filasAfect > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarEmpleadoDepto() {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE id_depa IS NULL LIMIT 1")) {

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static ArrayList<Empleados> mostrarEmpeladosSinDepto() {
        ArrayList<Empleados> listaEmpleados = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT dni,nombre,apellidos,email,salario,id_depa FROM empleados WHERE id_depa IS NULL")) {

            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Empleados empleados = new Empleados();
                empleados.setDni(resultSet.getString("dni"));
                empleados.setNombre(resultSet.getString("nombre"));
                empleados.setApellidos(resultSet.getString("apellidos"));
                empleados.setEmail(resultSet.getString("email"));
                empleados.setSalario(resultSet.getDouble("salario"));

                Integer idDepa = (Integer) resultSet.getObject("id_depa");
                empleados.setDepartamento(idDepa == null ? 0 : idDepa);

                listaEmpleados.add(empleados);

            }

            return listaEmpleados;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean asignarEmpleadoADepartamento(Empleados empleados, Departamento departamento) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE empleados SET id_depa = ? WHERE dni = ?")) {

            ps.setInt(1, departamento.getId());
            ps.setString(2, empleados.getDni());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean saberSiNoHayEmpeladoEnDepartamento() {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT 1 FROM empleados WHERE id_depa IS NULL LIMIT 1")) {
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean quedanEmpleadosLibres() {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT COUNT(*) AS libres FROM empleados e WHERE e.dni NOT IN (SELECT DISTINCT t.dni FROM trabaja t JOIN proyectos p ON t.id_proyect = p.id WHERE p.fechaInicio <= CURDATE() AND p.finalizado = 0)");
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                int libres = rs.getInt("libres");
                return libres > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static List<Proyecto> obtenerProyectosPorEmpleado(Empleados empleado) {
        List<Proyecto> lista = new ArrayList<>();

        String sql = "SELECT p.id, p.nombre,p.tipo, p.presupuesto, p.fechaInicio, p.finalizado " +
                "FROM proyectos p JOIN trabaja t ON p.id = t.id_proyect WHERE t.dni = ?";

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, empleado.getDni());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Proyecto p = new Proyecto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("tipo"),
                        rs.getDouble("presupuesto"),
                        rs.getDate("fechaInicio"),
                        rs.getBoolean("finalizado")
                );
                lista.add(p);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return lista;
    }


}
