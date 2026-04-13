package org.example.ControladorDAO;

import org.example.Modelo.Empleados;
import org.example.Modelo.Gerente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.Configuracion.Conexion.getConnect;

public class GerenteDAO {

    public GerenteDAO(){

    }

    public static boolean insertarGerente(Empleados empelados, Gerente gerente){
        try (Connection connection = getConnect();
             PreparedStatement ps  = connection.prepareStatement("INSERT INTO gerentes (dni,bono,nivel) VALUES (?,?,?)")){

            ps.setString(1, empelados.getDni());
            ps.setDouble(2, gerente.getBono());
            ps.setString(3, gerente.getNivel());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
