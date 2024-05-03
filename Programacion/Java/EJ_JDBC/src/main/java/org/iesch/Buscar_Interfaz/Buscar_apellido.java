package org.iesch.Buscar_Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar_apellido extends JFrame {
    private JTextField apellidoField;
    public Buscar_apellido(){
        this.setLayout(new FlowLayout());
        this.setTitle("Editar Alumno");

        JLabel textoLabel = new JLabel("Indica el apellido del alumno para buscarlo:  ");
        this.add(textoLabel);
        apellidoField = new JTextField(5);
        this.add(apellidoField);



        JButton insertarButton = new JButton("Buscar");
        this.add(insertarButton);
        this.setLayout(new GridLayout (3,1));

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String apellido = apellidoField.getText();

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    PreparedStatement pstmt = connection.prepareStatement("SELECT nombre, apellidos FROM alumno WHERE apellidos LIKE ?");
                    pstmt.setString(1, apellido );
                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        apellido = resultSet.getString("apellidos");


                        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nApellidos: " + apellido);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró alumno con el apellido " + apellido);
                    }
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }


            }
        });

        this.setSize(300, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Buscar_apellido buscarApellido = new Buscar_apellido();
        buscarApellido.setVisible(true);
    }
}
