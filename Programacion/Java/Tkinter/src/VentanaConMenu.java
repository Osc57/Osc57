import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConMenu extends JFrame {

   public VentanaConMenu(){
       setTitle("Ventana Principal");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500,500);

       JMenuBar menuBar = new JMenuBar();

       JMenu archivoMenu = new JMenu("Archivo");
       JMenu ayudaMenu = new JMenu("Ayuda");

       JMenuItem abrirItem = new JMenuItem("Abrir");
       abrirItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.out.println("Has hecho click en abrir");
           }
       });

       JMenuItem cerrarItem = new JMenuItem("Cerrar");
       cerrarItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });

       JMenuItem acercaDeItem = new JMenuItem("Acerca De");
       acercaDeItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showInternalMessageDialog(acercaDeItem, "Programa realizado por DAM1",
                       "Info del Programa",JOptionPane.INFORMATION_MESSAGE);

           }
       });

       archivoMenu.add(abrirItem);
       archivoMenu.add(cerrarItem);

       ayudaMenu.add(acercaDeItem);

       menuBar.add(archivoMenu);
       menuBar.add(ayudaMenu);

       setJMenuBar(menuBar);


   }

    public static void main(String[] args) {
        VentanaConMenu ventana = new VentanaConMenu();
        ventana.setVisible(true);
    }
}
