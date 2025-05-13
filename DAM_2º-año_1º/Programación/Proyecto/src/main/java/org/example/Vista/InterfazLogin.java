package org.example.Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazLogin extends JFrame {//Extiendo JFrame para ya tener un frame directamente y no tener que ir creandome un frame cade vez
    protected static final Color COLOR_BOTON = new Color(70, 130, 180);
    protected static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    protected static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);
    protected static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    protected static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    protected static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    protected static final Color COLOR_BOTONES = new Color(70, 130, 180);
    protected static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);
    protected static final Color COLOR_FONDO_BOTON = new Color(230, 230, 230);
    protected static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);
    protected static final Color COLOR_FONDO = new Color(240, 240, 240);

    protected static final Color COLOR_FONDO_LISTA = new Color(240, 240, 240);
    protected static final Color COLOR_BOTON_ACCEDER = new Color(70, 130, 180);
    protected static final Color COLOR_TEXTO_BOTON = Color.WHITE;

    private String administrador = "Admin";
    private String usuario = "Usuario";
    private String password = "1234";
    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public InterfazLogin() {
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        jPanel = new JPanel();
        jPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        this.setContentPane(jPanel);
        jPanel.setLayout(null);

        JLabel textoLabel = new JLabel("LOGIN");//Label del login
        textoLabel.setFont(FUENTE_TITULO);//Le doy un estilo a la letra
        textoLabel.setBounds(0, 30, 500, 50);//Le doy un tamaño a esta
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);//Centro el texto
        jPanel.add(textoLabel);//La añado al panel

//--------------------------------------------------------------------------------------------------------------

        JLabel user = new JLabel("USUARIO:");//Label de usuario
        user.setFont(FUENTE_LABEL);
        user.setBounds(50, 110, 150, 30);//Muevo y ajusto el label
        jPanel.add(user);//Lo añado al panel

        jTextField = new JTextField();//Me genero el jtextfield
        jTextField.setBounds(200, 110, 250, 35);//Le doy tamaño
        jTextField.setFont(FUENTE_CAMPOS);
        jPanel.add(jTextField);//Lo añado al panel

//--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");//Label de contraseña
        passw.setFont(FUENTE_LABEL);
        passw.setBounds(50, 170, 150, 30);//Muevo y ajusto el label
        jPanel.add(passw);

        jPasswordField = new JPasswordField();//Me genero el jtextfield de contraseña
        jPasswordField.setBounds(200, 170, 250, 35);//Le doy tamaño
        jPasswordField.setFont(FUENTE_CAMPOS);
        jPanel.add(jPasswordField);//Lo añado al panel

//--------------------------------------------------------------------------------------------------------------

        jButton = new JButton("INICIAR SESIÓN");//Me genero el botón
        jButton.setFont(FUENTE_BOTON);
        jButton.setBounds(150, 250, 200, 45);//Selecciono tamaño y ubicación del botón
        jButton.setBackground(COLOR_BOTON);//Color azul para el botón
        jButton.setForeground(Color.WHITE);//Texto blanco
        jPanel.add(jButton);//Lo añado al panel

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(jPasswordField.getPassword());
                String user = jTextField.getText();

                //Verifico el login de los usuarios que son recepcionistas
                if (user.equalsIgnoreCase(usuario)) {
                    if (pass.equals(password)) {
                        JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");

                        new InterfazSeleccionUsuario().setVisible(true);
                        dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "⚠\uFE0F Contraseña Incorrecta ⚠\uFE0F");
                    }
                }

                //Verfifico el login de el usuario que es jefe/admin
                if (user.equalsIgnoreCase(administrador)) {
                    if (pass.equals(password)) {
                        JOptionPane.showMessageDialog(null, "✅ Login Correcto ✅");

                        new InterfazSeleccionJefe().setVisible(true);
                        dispose();
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "⚠\uFE0F Contraseña Incorrecta ⚠\uFE0F");
                    }
                }
                JOptionPane.showMessageDialog(null, "⚠\uFE0F Usuario Incorrecto ⚠\uFE0F");
            }
        });

    }

    public static void main(String[] args) {
        InterfazLogin login1 = new InterfazLogin();
        login1.setVisible(true);
    }
}








