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
        this.setLayout(new GridLayout(4, 2));
        this.setTitle("Login");
        this.setSize(500, 450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN ");
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        jPanel.add(textoLabel);

        //--------------------------------------------------------------------------------------------------------------
        JLabel user = new JLabel("USUARIO:");
        jPanel.add(user, BorderLayout.WEST);
        user.setFont(new Font("Arial", Font.PLAIN, 25));
        user.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 67));

        jTextField = new JTextField();
        jTextField.setBounds(481, 170, 281, 68);
        jPanel.add(jTextField);
        jTextField.setColumns(15);

        //--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");
        jPanel.add(passw);
        passw.setFont(new Font("Arial", Font.PLAIN, 25));
        passw.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 67));


        jPasswordField = new JPasswordField();
        jPanel.add(jPasswordField, BorderLayout.CENTER);

        //--------------------------------------------------------------------------------------------------------------
        JButton botonIniciar = new JButton("Acceder");


        this.add(jPanel);

    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
