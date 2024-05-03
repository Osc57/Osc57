package org.iesch.interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eliminar extends JFrame{
    private JTextField idField;
    public Eliminar(){
        this.setLayout(new FlowLayout());
        this.setTitle("Editar Alumno");

        JLabel textoLabel = new JLabel("Indica el ID del alumno para eliminarlo:  ");
        this.add(textoLabel);
        idField = new JTextField(5);
        this.add(idField);



        JButton insertarButton = new JButton("Eliminar");
        this.add(insertarButton);
        this.setLayout(new GridLayout (3,1));

        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(idField.getText());

                try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alumnos", "root", "1234")) {
                    String query = "DELETE FROM alumno WHERE id= ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, id);
                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(Eliminar.this, "Estudiante eliminado correctamente");
                    pstmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(Eliminar.this, "Error al eliminar el estudiante: " + ex.getMessage());
                }
            }
        });

        this.setSize(300, 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Eliminar eliminar = new Eliminar();
        eliminar.setVisible(true);
    }
}
