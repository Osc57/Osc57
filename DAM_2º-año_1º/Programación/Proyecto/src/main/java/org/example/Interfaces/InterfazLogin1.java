package org.example.Interfaces;

import javax.swing.*;
import java.awt.*;

public class InterfazLogin1 extends JFrame {
    private String usuario = "Admin";
    private String password = "1234";
    private Font colortextoButton = new Font("Arial", Font.PLAIN, 18);

    public InterfazLogin1() {
        this.setLayout(new GridLayout(4, 2));
        this.setTitle("Login");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel textoLabel = new JLabel("LOGIN ");
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        this.add(textoLabel);

        //--------------------------------------------------------------------------------------------------------------
        
        JPanel panelUsuario = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel usuario = new JLabel("USUARIO:");
        panelUsuario.add(usuario, BorderLayout.WEST);
        usuario.setFont(new Font("Arial", Font.PLAIN, 25));
        usuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 67));

        JTextField usuarioTexto = new JTextField();
        usuarioTexto.setBounds(481, 170, 281, 68);
        panelUsuario.add(usuarioTexto);
        usuarioTexto.setColumns(15);

        //--------------------------------------------------------------------------------------------------------------

        JPanel panelPass = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel passw = new JLabel("CONTRASEÑA:");
        panelPass.add(passw, BorderLayout.WEST);
        passw.setFont(new Font("Arial", Font.PLAIN, 25));
        passw.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 67));


        JPasswordField passwordField = new JPasswordField(15);
        panelPass.add(passwordField, BorderLayout.CENTER);

        this.add(panelUsuario);
        this.add(panelPass);

    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
