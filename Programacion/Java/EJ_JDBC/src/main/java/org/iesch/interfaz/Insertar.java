package org.iesch.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insertar extends JFrame {
    private JTextField nombreField;
    private JTextField apellidosField;
    private JTextField direccionField;

    public Insertar() {
        this.setLayout(new FlowLayout());
        this.setTitle("Introducir Alumno");

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

        JButton insertarButton = new JButton("Insertar");
        this.add(insertarButton);

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellidos = apellidosField.getText();
                String direccion = direccionField.getText();

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    String query = "INSERT INTO alumno (nombre, apellidos, direccion) VALUES (?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setString(1, nombre);
                    pstmt.setString(2, apellidos);
                    pstmt.setString(3, direccion);
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(Insertar.this, "Estudiante insertado correctamente");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Insertar.this, "Error al insertar estudiante: " + ex.getMessage());
                }
            }
        });

        this.setSize(325, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Insertar();
    }
}
