package org.example.Vista;

import javax.swing.*;

public class Login extends JFrame{

    public Login(){
        this.setTitle("Login");
        this.setSize(500, 370);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        Login login = new Login();

        login.setVisible(true);
    }
}
