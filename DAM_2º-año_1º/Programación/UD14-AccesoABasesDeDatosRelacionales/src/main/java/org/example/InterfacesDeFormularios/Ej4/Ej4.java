package org.example.InterfacesDeFormularios.Ej4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.example.InterfacesDeFormularios.BBDD.connect;

public class Ej4 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(3,2));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();
        JLabel user = new JLabel("Nombre: ");
        JTextField usuario = new JTextField(20);
        jPanel1.add(user);
        jPanel1.add(usuario);

        JPanel jPanel2 = new JPanel();
        JLabel passw = new JLabel("Email: ");
        JTextField contrasena = new JTextField(20);
        jPanel2.add(passw);
        jPanel2.add(contrasena);

        JButton jButton = new JButton("Registrar");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = connect();
                     PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO usuario (nombre,email) VALUES (?,?);")) {

                    preparedStatement.setString(1, usuario.getText() );
                    preparedStatement.setString(2, contrasena.getText());

                    if (!usuario.getText().isEmpty() && !contrasena.getText().isEmpty()){
                        preparedStatement.executeUpdate();
                        JOptionPane.showMessageDialog(jFrame,"Usuario insertado correctamente");
                    }else {
                        JOptionPane.showMessageDialog(jFrame,"Rellena los datos");
                    }

                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(jFrame,"Error al insertar el usuario " + exception.getMessage());
                }
            }
        });

        jFrame.add(jPanel1);
        jFrame.add(jPanel2);
        jFrame.add(jButton);
        jFrame.setVisible(true);
    }
}
