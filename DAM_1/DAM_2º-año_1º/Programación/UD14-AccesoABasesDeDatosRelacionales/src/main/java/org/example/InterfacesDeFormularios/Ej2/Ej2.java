package org.example.InterfacesDeFormularios.Ej2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Diseña una interfaz con JTextField (usuario) y JPasswordField
 * (contraseña).
 *  Agrega un botón &quot;Iniciar sesión&quot;.
 *  Muestra un mensaje si el usuario y la contraseña son correctos
 * (ejemplo: &quot;admin&quot; / &quot;1234&quot;).
 **/

public class Ej2 extends JFrame{

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Hola mundo");
        jFrame.setLayout(new GridLayout(3,2));
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();
        JLabel user = new JLabel("Usuario: ");
        JTextField usuario = new JTextField(20);
        jPanel1.add(user);
        jPanel1.add(usuario);

        JPanel jPanel2 = new JPanel();
        JLabel passw = new JLabel("Contraseña: ");
        JPasswordField contrasena = new JPasswordField(20);
        jPanel2.add(passw);
        jPanel2.add(contrasena);

        JPanel jPanel3 = new JPanel();
        JButton jButton = new JButton("Iniciar Sesión");
        jPanel3.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (usuario.getText().equals("admin") && contrasena.getText().equals("1234")){
                    JOptionPane.showMessageDialog(jFrame,"Inicio de sesión correcto");
                }else {
                    JOptionPane.showMessageDialog(jFrame,"Error al iniciar sesión");
                }
            }
        });


        jFrame.add(jPanel1);
        jFrame.add(jPanel2);
        jFrame.add(jPanel3);
        jFrame.setVisible(true);

    }
}
