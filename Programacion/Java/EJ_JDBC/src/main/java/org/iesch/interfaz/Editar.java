package org.iesch.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Editar extends JFrame{
    private JTextField idField;
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField direccionField;

    public Editar() {
        this.setLayout(new FlowLayout());
        this.setTitle("Editar Alumno");

        JLabel idLabel = new JLabel("Id:             ");
        this.add(idLabel);
        idField = new JTextField(20);
        this.add(idField);

        JLabel nombreLabel = new JLabel("Nombre:  ");
        this.add(nombreLabel);
        nombreField = new JTextField(20);
        this.add(nombreField);

        JLabel apellidosLabel = new JLabel("Apellidos:");
        this.add(apellidosLabel);
        apellidosField = new JTextField(20);
        this.add(apellidosField);

        JLabel direccionLabel = new JLabel("Dirección:");
        this.add(direccionLabel);
        direccionField = new JTextField(20);
        this.add(direccionField);

        JButton insertarButton = new JButton("Editar");
        this.add(insertarButton);

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String direccion = direccionField.getText();

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    String query = "UPDATE alumno SET nombre = ?, apellidos=?, direccion=? WHERE id= ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellidos);
                    pstmt.setString(3, direccion);
                    pstmt.setInt(4, id);
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(Editar.this, "Estudiante editado correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Editar.this, "Error al editar el estudiante: " + ex.getMessage());
                }
            }
        });

        this.setSize(350, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        Editar editar = new Editar();
        editar.setVisible(true);
    }
}
