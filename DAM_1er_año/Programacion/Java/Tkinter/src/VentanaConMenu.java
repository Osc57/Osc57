import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
               //Creo el JFileChooser
               JFileChooser fileChooser = new JFileChooser();
               int valorRetornado = fileChooser.showOpenDialog(VentanaConMenu.this);
               //System.out.println(valorRetornado);
               if (valorRetornado == JFileChooser.APPROVE_OPTION){
                   File archivoSeleccionado = fileChooser.getSelectedFile();
                   System.out.println(archivoSeleccionado.getAbsolutePath());
               }

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

       JMenuItem acercaDeItem2 = new JMenuItem("Acerca De...");
       acercaDeItem2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               //Crear y mostrar un JDialog como ventana emergente
               JDialog dialog = new JDialog(VentanaConMenu.this, "Acerca de...  titulo",true);
               dialog.setSize(300,300);
               dialog.setLayout(new BorderLayout());
               JLabel text = new JLabel("<html><center>Esta es una aplicación de ejemplo <br> Versión 1.0</center></html>");
               dialog.add(text,BorderLayout.CENTER);

               JButton okButton = new JButton("Ok");
               okButton.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent e) {
                       dialog.dispose();
                   }
               });

               dialog.add(okButton, BorderLayout.SOUTH);
               //Centrar en la pantalla:
               dialog.setLocationRelativeTo(VentanaConMenu.this);
               dialog.setVisible(true);


           }
       });

       archivoMenu.add(abrirItem);
       archivoMenu.add(cerrarItem);

       ayudaMenu.add(acercaDeItem);
       ayudaMenu.add(acercaDeItem2);

       menuBar.add(archivoMenu);
       menuBar.add(ayudaMenu);

       setJMenuBar(menuBar);


   }

    public static void main(String[] args) {
        VentanaConMenu ventana = new VentanaConMenu();
        ventana.setVisible(true);
    }
}
