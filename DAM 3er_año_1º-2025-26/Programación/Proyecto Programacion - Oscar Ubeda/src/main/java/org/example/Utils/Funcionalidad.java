package org.example.Utils;

import org.example.Modelo.*;
import org.example.Vista.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static org.example.ControladorDAO.EmpleadosDAO.emailExistente;

public class Funcionalidad {
    public static final Font FUENTE_TITULO = new Font("Arial", Font.BOLD, 42);
    public static final Font FUENTE_TITULO_2 = new Font("Arial", Font.BOLD, 25);

    public static final Color COLOR_FONDO_GRIS_CLARO = new Color(240, 240, 240);
    public static final Color COLOR_BOTON_GRIS_CLARO = new Color(230, 230, 230);

    public static final Color COLOR_BOTONES_AZUL = new Color(70, 130, 180);

    public static final Font FUENTE_LABEL = new Font("Arial", Font.BOLD, 18);
    public static final Font FUENTE_CAMPOS = new Font("Arial", Font.PLAIN, 16);
    public static final Font FUENTE_EMOJI = new Font("Arial", Font.BOLD, 25);

    public static final Font FUENTE_BOTON = new Font("Arial", Font.BOLD, 18);
    public static final Font FUENTE_BOTONES = new Font("Arial", Font.BOLD, 18);

    public static final Font FUENTE_TEXTO = new Font("Segoe UI", Font.PLAIN, 16);

    //========================================================================================================

    public static final DefaultListModel<Empleados> MODEL_EMPLEADOS = new DefaultListModel<>();
    public static final JList<Empleados> LISTA_EMPLEADOS = new JList<>(MODEL_EMPLEADOS);

    public static final DefaultListModel<Programador> MODEL_PROGRAM = new DefaultListModel<>();
    public static final JList<Programador> LISTA_PROGRAM = new JList<>(MODEL_PROGRAM);

    public static final DefaultListModel<Gerente> MODEL_GERENTE = new DefaultListModel<>();
    public static final JList<Gerente> LISTA_GERENTE = new JList<>(MODEL_GERENTE);

    public static final DefaultListModel<Departamento> MODEL_DEPTO = new DefaultListModel<>();
    public static final JList<Departamento> LISTA_DEPTO = new JList<>(MODEL_DEPTO);

    public static final DefaultListModel<Proyecto> MODEL_PROYECT = new DefaultListModel<>();
    public static final JList<Proyecto> LIST_PROYECT = new JList<>(MODEL_PROYECT);

    //========================================================================================================

    private static final String DOMINIO = "@empresa.emp";

    public static final double MIN_PROG = 1600.0;
    public static final double MAX_PROG = 7000.0;

    public static final double MIN_MES = 1425.0;
    public static final double MAX_MES = 18000.0;

    public static final int N_PISOS = 5;

    //===============================================================================================

    public static JButton crearEstiloBotonSubmit(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 50, 10, 45)
        ));
        return boton;
    }

    public static JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTON);
        boton.setBackground(COLOR_BOTON_GRIS_CLARO);
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(-10, -10, -10, -20)
        ));
        return boton;
    }

    public static JPanel getPanelBotonRetorno(JFrame ventanaActual, JFrame ventanaDestino) {

        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");

        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(e -> {
            ventanaActual.setVisible(false);
            ventanaDestino.setVisible(true);
        });

        return panelBotonRetorno;
    }

    public static JTextField crearFields() {
        JTextField field = new JTextField(19);
        field.setFont(FUENTE_CAMPOS);
        field.setPreferredSize(new Dimension(150, 30));

        return field;
    }

    public static JLabel crearLabels(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        return label;
    }

    public static JRadioButton crearRadioButtonEstilizado(String texto, boolean seleccionado) {
        JRadioButton rb = new JRadioButton(texto, seleccionado);

        // Estética: Fuente, color y quitar el borde de foco
        rb.setFont(FUENTE_LABEL);
        rb.setFocusPainted(false);
        rb.setOpaque(false); // Para que tome el color del panel de fondo
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return rb;
    }

    //===============================================================================================

    public static void configurarCierreVentana(JFrame ventana) {
        ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int respuesta = JOptionPane.showConfirmDialog(ventana, "¿Quiere cerrar sesión?", "Cerrar sesión",
                        JOptionPane.YES_NO_OPTION);

                if (respuesta == JOptionPane.YES_OPTION) {
                    ventana.dispose();
                    new Login().setVisible(true);
                }
            }
        });
    }

    //===============================================================================================

    public static void configurarListaEnScroll(JList<?> lista) {

        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lista.setFont(new Font("Arial", Font.PLAIN, 18));
        lista.setFixedCellHeight(35);
        lista.setBackground(COLOR_FONDO_GRIS_CLARO);
    }

    //===============================================================================================

    public static String generarEmailBase(String nombre, String apellidos) {
        nombre = nombre.trim().toLowerCase();
        apellidos = apellidos.trim().toLowerCase();

        char primeraLetra = nombre.charAt(0);

        String[] partes = apellidos.split(" ");
        String primerApellido = partes[0];
        String letraSegundoApellido = partes.length >= 2 ? String.valueOf(partes[1].charAt(0)) : "";

        return primeraLetra + primerApellido + letraSegundoApellido;
    }

    public static String generarEmailUnico(String nombre, String apellidos) {

        String base = generarEmailBase(nombre, apellidos);


        // Empleado temporal para comprobar duplicados
        Empleados temp = new Empleados();
        temp.setEmail(base + DOMINIO);

        // 1. Si no existe, perfecto
        if (!emailExistente(temp)) {
            return temp.getEmail();
        }

        // 2. Añadir más letras del nombre
        nombre = nombre.toLowerCase();
        for (int i = 1; i < nombre.length(); i++) {
            temp.setEmail(base + nombre.charAt(i) + DOMINIO);
            if (!emailExistente(temp)) {
                return temp.getEmail();
            }
        }

        // 3. Añadir más letras del apellido
        apellidos = apellidos.toLowerCase();
        String[] partes = apellidos.split(" ");
        String primerApellido = partes[0];

        for (int i = 1; i < primerApellido.length(); i++) {
            temp.setEmail(base + primerApellido.charAt(i) + DOMINIO);
            if (!emailExistente(temp)) {
                return temp.getEmail();
            }
        }

        // 4. Último recurso elegante (sin números)
        temp.setEmail(base + "_" + UUID.randomUUID().toString().substring(0, 4) + DOMINIO);
        return temp.getEmail();
    }

    // Esta versión prepara los datos y llama a la tuya
    public static String generarEmailUnicoLimpio(String nombre, String apellidos) {
        return generarEmailUnico(quitarTildes(nombre), quitarTildes(apellidos));
    }

    // Función auxiliar de limpieza
    private static String quitarTildes(String texto) {
        if (texto == null) return "";
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);

        return normalizado.replaceAll("[^\\p{ASCII}]", "");
    }

    //===============================================================================================

    public static class Log {

        private static final String RUTA_LOG = "logs/login_log.txt";

        public static void registrar(String mensaje) {
            try (FileWriter fw = new FileWriter(RUTA_LOG, true)) {

                String fechaHora = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                fw.write("[" + fechaHora + "] " + mensaje + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
