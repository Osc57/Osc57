import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora {
    static double botonPorDefecto = 0;
    static boolean botonPresionado = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        panel1.setLayout(new GridLayout(1,1));
        panel2.setLayout(new GridLayout(4,4));

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(150,150));

        panel1.add(textField);

        JButton button7 = new JButton("7");
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 7;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button7);

        JButton button8 = new JButton("8");
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 8;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button8);

        JButton button9 = new JButton("9");
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 9;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button9);

        JButton dividir = new JButton("/");
        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                }
            }
        });
        panel2.add(dividir);

        JButton button4 = new JButton("4");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 4;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button4);

        JButton button5 = new JButton("5");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 5;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button5);

        JButton button6 = new JButton("6");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 6;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button6);

        JButton multiplicar = new JButton("*");
        multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                }
            }
        });
        panel2.add(multiplicar);

        JButton button1 = new JButton("1");
        panel2.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 1;
                }
                System.out.println(botonPorDefecto);
            }
        });

        JButton button2 = new JButton("2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 2;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button2);

        JButton button3 = new JButton("3");
        panel2.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 3;
                }
                System.out.println(botonPorDefecto);
            }
        });

        JButton restar = new JButton("-");
        panel2.add(restar);


        JButton coma = new JButton(",");
        panel2.add(coma);
        JButton button = new JButton("0");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){
                    botonPorDefecto = 0;
                }
                System.out.println(botonPorDefecto);
            }
        });
        panel2.add(button);

        JButton igual = new JButton("=");
        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado){

                }

            }
        });
        panel2.add(igual);

        JButton sumar = new JButton("+");
        sumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel2.add(sumar);

        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);


        frame.setVisible(true);

    }
}
