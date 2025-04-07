package org.example.InterfacesDeFormularios.Ej5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.example.InterfacesDeFormularios.BBDD.connect;

public class Ej5 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(2, 1));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Email");

        JTable jt = new JTable(modelo);

        JButton jButton = new JButton("Actualizar");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM usuario;")) {

                    ResultSet resultSet = preparedStatement.executeQuery();

                    while (resultSet.next()){
                        modelo.addRow(new Object[]{
                                resultSet.getInt("id"),
                                resultSet.getString("nombre"),
                                resultSet.getString("email")
                        });
                    }

                } catch (
                        Exception exception) {
                    JOptionPane.showMessageDialog(jFrame, "Error al cargar datos " + exception.getMessage());
                }
            }
        });

        jFrame.add(jt);
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
}
