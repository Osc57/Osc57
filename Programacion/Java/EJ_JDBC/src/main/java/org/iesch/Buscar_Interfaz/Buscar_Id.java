package org.iesch.Buscar_Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Buscar_Id extends JFrame {
    private JTextField idField;
    public Buscar_Id(){
        this.setLayout(new FlowLayout());
        this.setTitle("Editar Alumno");

        JLabel textoLabel = new JLabel("Indica el ID del alumno para buscarlo:  ");
        this.add(textoLabel);
        idField = new JTextField(5);
        this.add(idField);



        JButton insertarButton = new JButton("Buscar");
        this.add(insertarButton);
        this.setLayout(new GridLayout (3,1));

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    PreparedStatement pstmt = connection.prepareStatement("SELECT nombre, apellidos FROM alumno WHERE id = ?");
                    pstmt.setInt(1, id);
                    ResultSet resultSet = pstmt.executeQuery();

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String apellidos = resultSet.getString("apellidos");


                        JOptionPane.showMessageDialog(null, "Nombre: " + nombre + "\nApellidos: " + apellidos);
                        pstmt.close();
                        connection.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró alumno con el ID " + id);
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
        Buscar_Id buscarId = new Buscar_Id();
        buscarId.setVisible(true);
    }
}
