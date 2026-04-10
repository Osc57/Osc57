package org.example.Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    protected static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    protected static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);

    protected static final Color COLOR_FONDO_GRIS_CLARO = new Color(240, 240, 240);
    protected static final Color COLOR_BOTON_GRIS_CLARO = new Color(230, 230, 230);

    protected static final Color COLOR_BOTONES_AZUL = new Color(70, 130, 180);

    protected static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    protected static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    protected static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);


    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public Login() {
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");
        textoLabel.setFont(FUENTE_TITULO);
        textoLabel.setBounds(0, 30, 500, 50);
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel.add(textoLabel);

        //======================================================================================================

        JLabel user = new JLabel("USUARIO:");
        user.setFont(FUENTE_LABEL);
        user.setBounds(50, 110, 150, 30);
        jPanel.add(user);

        jTextField = new JTextField();
        jTextField.setBounds(200, 110, 250, 35);
        jTextField.setFont(FUENTE_CAMPOS);
        jPanel.add(jTextField);

        //======================================================================================================

        JLabel passw = new JLabel("CONTRASEÑA:");
        passw.setFont(FUENTE_LABEL);
        passw.setBounds(50, 170, 150, 30);
        jPanel.add(passw);

        jPasswordField = new JPasswordField();
        JPanel passwordPanel = new JPanel(jPasswordField.getLayout());

        passwordPanel.setBounds(200, 170, 250, 35);
        passwordPanel.setFont(FUENTE_CAMPOS);
        jPanel.add(passwordPanel);


        //======================================================================================================



    }


    public static void main(String[] args) {
        Login login = new Login();

        login.setVisible(true);
    }
}
