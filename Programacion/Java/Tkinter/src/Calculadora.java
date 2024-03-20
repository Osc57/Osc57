import javax.swing.*;
import java.awt.*;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        Panel panel1 = new Panel();
        Panel panel2 = new Panel();
        panel1.setLayout(new GridLayout(1,2));
        panel2.setLayout(new GridLayout(4,4));

        JTextField textField = new JTextField();

        panel1.add(textField);

        JButton button7 = new JButton("7");
        panel2.add(button7);

        JButton button8 = new JButton("8");
        panel2.add(button8);

        JButton button9 = new JButton("9");
        panel2.add(button9);

        JButton dividir = new JButton("/");
        panel2.add(dividir);

        JButton button4 = new JButton("4");
        panel2.add(button4);

        JButton button5 = new JButton("5");
        panel2.add(button5);

        JButton button6 = new JButton("6");
        panel2.add(button6);

        JButton multiplicar = new JButton("*");
        panel2.add(multiplicar);

        JButton button1 = new JButton("1");
        panel2.add(button1);

        JButton button2 = new JButton("2");
        panel2.add(button2);

        JButton button3 = new JButton("3");
        panel2.add(button3);

        JButton restar = new JButton("-");
        panel2.add(restar);

        JButton button = new JButton("0");
        panel2.add(button);

        JButton coma = new JButton(",");
        panel2.add(coma);

        JButton igual = new JButton("=");
        panel2.add(igual);

        JButton sumar = new JButton("+");
        panel2.add(sumar);

        frame.setLayout(new FlowLayout());
        frame.add(panel1);
        frame.add(panel2);



        frame.setVisible(true);

    }
}
