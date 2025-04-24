package org.example.Interfaces;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazLogin1 extends JFrame {//Extiendo JFrame para ya tener un frame directamente y no tener que ir creandome un frame cade vez
    private String usuario = "Admin";
    private String password = "1234";
    private Font colortextoButton = new Font("Arial", Font.PLAIN, 18);
    private JPanel jPanel;
    private JTextField jTextField;
    private JButton jButton;
    private JPasswordField jPasswordField;

    public InterfazLogin1() {
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
        textoLabel.setFont(new Font("Arial", Font.PLAIN, 40));//Le doy un estilo a la letra
        textoLabel.setBounds(170, 20, 200, 50);//Le doy un tamaño a esta
        jPanel.add(textoLabel);//La añado al panel

        //--------------------------------------------------------------------------------------------------------------

        JLabel user = new JLabel("USUARIO:");//Label de usuario
        user.setFont(new Font("Arial", Font.PLAIN, 20));
        user.setBounds(50, 100, 150, 30);//Muevo y ajusto el label
        jPanel.add(user);//Lo añado al panel

        jTextField = new JTextField();//Me genero el jtextfield
        jTextField.setBounds(200, 100, 200, 30);//Le doy tamaño
        jPanel.add(jTextField);//Lo añado al panel

        //--------------------------------------------------------------------------------------------------------------

        JLabel passw = new JLabel("CONTRASEÑA:");//Label de contraseña
        passw.setFont(new Font("Arial", Font.PLAIN, 20));
        passw.setBounds(50, 160, 150, 30);//Muevo y ajusto el label
        jPanel.add(passw);

        jPasswordField = new JPasswordField();//Me genero el jtextfield de contraseña
        jPasswordField.setBounds(200, 160, 200, 30);//Le doy tamaño
        jPanel.add(jPasswordField);//Lo añado al panel

        //--------------------------------------------------------------------------------------------------------------

        jButton = new JButton("Iniciar sesión");//Me genero el botón
        jButton.setFont(colortextoButton);//Le doy un estilo a la letra que esta dentro del botón
        jButton.setBounds(150, 250, 180, 40);//Selecciono tamaño y ubicación del botón
        jPanel.add(jButton);//Lo añado al panel

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass = new String(jPasswordField.getPassword());
                if (jTextField.getText().equalsIgnoreCase(usuario) && pass.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Correcto");
                    InterfazLogin2 login2 = new InterfazLogin2();
                    login2.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Login Incorrecto");
                }
            }
        });
    }

    public static void main(String[] args) {
        InterfazLogin1 login1 = new InterfazLogin1();
        login1.setVisible(true);
    }
}
