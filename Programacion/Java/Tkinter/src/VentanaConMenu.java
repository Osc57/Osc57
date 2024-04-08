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

       JMenuItem ayudaItem = new JMenuItem("Ayuda");
       ayudaItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               
           }
       });

       archivoMenu.add(abrirItem);
       archivoMenu.add(cerrarItem);
       archivoMenu.add(ayudaItem);

       menuBar.add(archivoMenu);

       setJMenuBar(menuBar);


   }

    public static void main(String[] args) {
        VentanaConMenu ventana = new VentanaConMenu();
        ventana.setVisible(true);
    }
}
