import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener{
    static boolean botonPresionado = false;
    static int botonPorDefecto = 0;
    static JButton[] botonOperacion;
    private String operando1;
    private String operacion;
    private static JTextField textField;
    private String ultimateclaPresionada = "";
    

    public Calculadora() {
        //JFrame frame = new JFrame("Calculadora");
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 500);


        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();

        panel1.setLayout(new GridLayout(1, 1));
        panel2.setLayout(new GridLayout(4, 3));
        panel3.setLayout(new GridLayout(5,1));

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 150));
        textField.setEditable(false);
        Font font = new Font("Calibri", Font.BOLD,70);
        textField.setFont(font);

        panel1.add(textField);

        JButton button7 = new JButton("7");
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 7;
                    textField.setText(textField.getText() + botonPorDefecto);
                }

            }
        });
        panel2.add(button7);

        JButton button8 = new JButton("8");
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 8;
                    textField.setText(textField.getText() + botonPorDefecto);
                }

            }
        });
        panel2.add(button8);

        JButton button9 = new JButton("9");
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 9;
                    textField.setText(textField.getText() + botonPorDefecto);
                }

            }
        });
        panel2.add(button9);


        JButton button4 = new JButton("4");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 4;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });
        panel2.add(button4);

        JButton button5 = new JButton("5");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 5;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });
        panel2.add(button5);

        JButton button6 = new JButton("6");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 6;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });
        panel2.add(button6);


        JButton button1 = new JButton("1");
        panel2.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 1;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });

        JButton button2 = new JButton("2");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 2;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });
        panel2.add(button2);

        JButton button3 = new JButton("3");
        panel2.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 3;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });

        JButton vacio = new JButton();
        panel2.add(vacio);
        JButton button = new JButton("0");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!botonPresionado) {
                    botonPorDefecto = 0;
                    textField.setText(textField.getText() + botonPorDefecto);
                }
            }
        });
        panel2.add(button);
        JButton vacio2 = new JButton();
        panel2.add(vacio2);

        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.EAST);

        crearBotonesDeOperaciones(panel3, this);

    }

    private static void crearBotonesDeOperaciones(JPanel panel3, Calculadora calculadora) {
        botonOperacion = new JButton[5];
        botonOperacion[0] = new JButton("/");
        botonOperacion[1] = new JButton("*");
        botonOperacion[2] = new JButton("-");
        botonOperacion[3] = new JButton("+");
        botonOperacion[4] = new JButton("=");

        for (int i = 0; i < botonOperacion.length; i++) {
            panel3.add(botonOperacion[i]);
            botonOperacion[i].addActionListener((ActionListener) calculadora);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Obtener el botón presionado:
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();

        //Si se presiona un número, tendré que escribirlo en el TextField
        if (buttonText.matches("[0-9]")){
            if (ultimateclaPresionada.equals("=")){
                textField.setText("");
            }
            ultimateclaPresionada = buttonText;
            textField.setText(textField.getText() + buttonText);
        }
        //Sí se presiona un operador (+-*/) --> Calcular
        else if (buttonText.matches("[+\\-*/]")) {
            ultimateclaPresionada = buttonText;
            operando1 = textField.getText();
            textField.setText(operando1 + buttonText);
            operacion = buttonText;
        } else if (buttonText.equals("=")) {
            //guardarme el numero de la pantalla.
            ultimateclaPresionada = buttonText;
            String operando2 = textField.getText();

            operando2 = operando2.replace(operando1 + operacion, "");
            textField.setText("");
            int resultado = 0;
            if (operacion.equals("+")) {
                ultimateclaPresionada = buttonText;
                resultado = Integer.parseInt(operando1) + Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }
            else if (operacion.equals("-")){
                ultimateclaPresionada = buttonText;
                resultado = Integer.parseInt(operando1) - Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }else  if (operacion.equals("*")){
                ultimateclaPresionada = buttonText;
                resultado = Integer.parseInt(operando1) * Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }else  if (operacion.equals("/")){
                ultimateclaPresionada = buttonText;
                resultado = Integer.parseInt(operando1) / Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }
            // Limpiar los valores de los operandos y la operación
            operando1 = "";
            operando2 = "";
            operacion = "";
        }
    }

    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }
}
