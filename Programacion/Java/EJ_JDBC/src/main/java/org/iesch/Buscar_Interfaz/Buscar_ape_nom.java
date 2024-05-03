package org.iesch.Buscar_Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar_ape_nom extends JFrame {
    private JTextField apellidoField;
    private JTextField nombreField;
    public Buscar_ape_nom(){
        this.setLayout(new FlowLayout());
        this.setTitle("Editar Alumno");

        JLabel nombreLabel = new JLabel("Nombre:  ");
        this.add(nombreLabel);
        nombreField = new JTextField(5);
        this.add(nombreField);

        JLabel apellidoLabel = new JLabel("Apellido:  ");
        this.add(apellidoLabel);
        apellidoField = new JTextField(5);
        this.add(apellidoField);

        JButton insertarButton = new JButton("Buscar");
        this.add(insertarButton);
        this.setLayout(new GridLayout (5,1));

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    PreparedStatement pstmt = connection.prepareStatement("SELECT nombre, apellidos FROM alumno WHERE nombre LIKE ? AND apellidos LIKE ?");
                    pstmt.setString(1, "%" + nombre + "%");
                    pstmt.setString(2, "%" + apellido + "%");
                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        nombre = resultSet.getString("nombre");
                        apellido = resultSet.getString("apellidos");


                        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nApellidos: " + apellido);
                        pstmt.close();
                        connection.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró alumno con el apellido " + apellido);
                    }
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }


            }
        });

        this.setSize(300, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Buscar_ape_nom buscarApeNom = new Buscar_ape_nom();
        buscarApeNom.setVisible(true);
    }
}
