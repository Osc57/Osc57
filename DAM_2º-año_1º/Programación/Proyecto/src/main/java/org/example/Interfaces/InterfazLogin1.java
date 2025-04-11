package org.example.Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterfazLogin1 extends JFrame {
    private String usuario = "Admin";
    private String password = "1234";
    private Font colortextoButton = new Font("Arial", Font.PLAIN, 18);
    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public InterfazLogin1() {
        this.setTitle("Login");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        textoLabel.setBounds(170, 20, 200, 50);
        jPanel.add(textoLabel);

        //--------------------------------------------------------------------------------------------------------------

        JLabel user = new JLabel("USUARIO:");
        user.setFont(new Font("Arial", Font.PLAIN, 20));
        user.setBounds(50, 100, 150, 30);
        jPanel.add(user);

        jTextField = new JTextField();
        jTextField.setBounds(200, 100, 200, 30);
        jPanel.add(jTextField);

        //--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");
        passw.setFont(new Font("Arial", Font.PLAIN, 20));
        passw.setBounds(50, 160, 150, 30);
        jPanel.add(passw);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(200, 160, 200, 30);
        jPanel.add(jPasswordField);

        //--------------------------------------------------------------------------------------------------------------

        jButton = new JButton("Iniciar sesión");
        jButton.setFont(colortextoButton);
        jButton.setBounds(150, 230, 180, 40);
        jPanel.add(jButton);
    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
