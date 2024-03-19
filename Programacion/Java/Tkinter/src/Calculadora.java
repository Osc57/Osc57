import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);

        JButton button9 = new JButton("9");
        JButton button8 = new JButton("8");
        JButton button7 = new JButton("7");
        JButton button6 = new JButton("6");
        JButton button5 = new JButton("5");
        JButton button4 = new JButton("4");
        JButton button3 = new JButton("3");
        JButton button2 = new JButton("2");
        JButton button1 = new JButton("1");
        JButton button = new JButton("0");


        JPanel panel = new JPanel();
        panel.add(button9);
        panel.add(button8);
        panel.add(button7);
        panel.add(button6);
        panel.add(button5);
        panel.add(button4);
        panel.add(button3);
        panel.add(button2);
        panel.add(button1);
        panel.add(button);


        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}
