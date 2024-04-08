import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class VisorImagenes extends JFrame{

    private ArrayList<File> imagenes = new ArrayList<>();
    private int indiceImagenActual = 0;

    private JLabel visorDeImagenes;

    public VisorImagenes(){

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Archivo");
        JMenuItem abrir = new JMenuItem("Abrir");

        menu.add(abrir);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        //Creamos el visor de imágenes:
        visorDeImagenes = new JLabel();
        add(visorDeImagenes, BorderLayout.CENTER);

        //Creamos el botón para pasar
        JButton siguienteImagen = new JButton("->");
        add(siguienteImagen, BorderLayout.EAST);


        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                //Solo os deje seleccionar directorios
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int returnValue = fileChooser.showOpenDialog(VisorImagenes.this);

                if (returnValue == JFileChooser.APPROVE_OPTION){
                    File directorioSeleccionado = fileChooser.getSelectedFile();
                    cargarImagenes(directorioSeleccionado);
                    mostrarImagen();

                }
            }
        });

        //Programamos el clic al botón de pasar
        siguienteImagen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indiceImagenActual = (indiceImagenActual + 1);
                if (indiceImagenActual >= imagenes.size()){
                    indiceImagenActual = 0;
                }
                mostrarImagen();
            }
        });

        //Configurar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,1000);
        setVisible(true);


    }

    private void mostrarImagen() {
        try {
            BufferedImage imagen = ImageIO.read(imagenes.get(indiceImagenActual));
            visorDeImagenes.setIcon(new ImageIcon(imagen));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarImagenes(File directorioSeleccionado) {
        for (File file : directorioSeleccionado.listFiles()){
            if (esImagen(file)){
                imagenes.add(file);
            }
        }
    }

    private boolean esImagen(File file) {
        String nombreArchivo = file.getName().toLowerCase();
        return nombreArchivo.endsWith(".png") || nombreArchivo.endsWith(".jpg") || nombreArchivo.endsWith(".jpeg");
    }

    public static void main(String[] args) {
        new VisorImagenes();
    }
}
