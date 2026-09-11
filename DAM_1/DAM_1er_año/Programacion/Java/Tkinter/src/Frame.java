import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi primer JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JButton button = new JButton("Botón 1");
        JButton button1 = new JButton("Botón 2");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(button);
        panel.add(button1);

        frame.getContentPane().add(panel);
        frame.setVisible(true);


    }
}
