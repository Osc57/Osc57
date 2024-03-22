import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora2 extends JFrame implements ActionListener{

    private JButton[] buttonsNumbers;
    private JButton[] buttonsOperaciones;
    private JTextField textField;
    private String operando1;
    private String operacion;
    public Calculadora2() {
        this.setTitle("Calculadora");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 500);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        panel1.setLayout(new GridLayout(1, 1));
        panel2.setLayout(new GridLayout(4, 4));
        panel3.setLayout(new GridLayout(4, 2));

        Font font = new Font("Calibri", Font.BOLD,28);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(150, 150));
        textField.setFont(font);
        textField.setEditable(false);
        panel1.add(textField);
        this.add(panel1,BorderLayout.NORTH);

        creaBotones(panel2,this);
        this.add(panel2,BorderLayout.CENTER);

        creaBotonesOperaciones(panel3,this);
        this.add(panel3,BorderLayout.EAST);

    }

    private void creaBotonesOperaciones(JPanel panel3, Calculadora2 calculadora2) {
        buttonsOperaciones = new JButton[5];
        buttonsOperaciones[0] = new JButton("*");
        buttonsOperaciones[1] = new JButton("/");
        buttonsOperaciones[2] = new JButton("+");
        buttonsOperaciones[3] = new JButton("-");
        buttonsOperaciones[4] = new JButton("=");

        for (int i = 0; i < buttonsOperaciones.length; i++) {
            panel3.add(buttonsOperaciones[i]);
            //tratar evento
            buttonsNumbers[i].addActionListener((ActionListener) calculadora2);
        }
    }

    private void creaBotones(JPanel panel2, Calculadora2 ventana) {
        buttonsNumbers = new JButton[10];
        for(int i = 9; i >= 0; i--){
            buttonsNumbers[i] = new JButton(Integer.toString(i));
            panel2.add(buttonsNumbers[i]);
            //tratar evento
            buttonsNumbers[i].addActionListener((ActionListener) ventana);
        }
    }



    public  void  actionPerformed(ActionEvent e){
        //Obtener el boton presionado:
        JButton boton = (JButton) e.getSource();
        String textoDelBoton = boton.getText();
        //Si se presiona un número, tendré que escribirlo en el TextField
        if (textoDelBoton.matches("[0-9]")){
            textField.setText(textField.getText() + textoDelBoton);
        }
        //Sí se presiona un operador(+-*/) --> Calcular
        else if (textoDelBoton.matches("[+\\-*/]")) {
            operando1 = textField.getText();
            textField.setText(operando1 + textoDelBoton);
            operacion = textoDelBoton;
            System.out.println(operando1 + operacion);
        } else if (textoDelBoton.equals("=")) {
            //guardarme el número de la pantalla
            String operando2 = textField.getText();
            operando2 = operando2.replace(operando1 + operacion, "");
            textField.setText("");
            int resultado=0;
            if (operacion.equals("+")){
               resultado = Integer.parseInt(operando1 + operando2);
               textField.setText("" + resultado);
            }else if (operacion.equals("-")){
                resultado = Integer.parseInt(operando1) - Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }else if (operacion.equals("*")){
                resultado = Integer.parseInt(operando1) * Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }else if (operacion.equals("/")){
                resultado = Integer.parseInt(operando1) / Integer.parseInt(operando2);
                textField.setText("" + resultado);
            }
        }
    }

    public static void main(String[] args) {
            Calculadora2 calculadora = new Calculadora2();
            calculadora.setVisible(true);



        }
    }


