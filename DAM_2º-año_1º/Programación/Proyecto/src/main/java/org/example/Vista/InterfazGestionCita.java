package org.example.Vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import org.example.Modelo.Trabajador;
import org.example.Modelo.Tratamiento;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.SimpleBeanInfo;
import java.text.SimpleDateFormat;

import static org.example.Controlador.ControladorRecepcionista.cargarTratamientos;
import static org.example.Vista.InterfazLogin.*;

public class InterfazGestionCita extends JFrame {

    private final Color COLOR_F = new Color(50, 50, 50);

    public InterfazGestionCita() {
        this.setTitle("Dar Cita");
        this.setSize(490, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione fecha para el cliente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));


        JPanel panelCalendario = getjPanelPanelCalendario();
        JPanel panelBotonRetorno = getjPanelBotonRetorno();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelCalendario, BorderLayout.CENTER);
        this.add(panelBotonRetorno, BorderLayout.SOUTH);
    }

    private JPanel getjPanelPanelCalendario() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel panelCalendar = new JPanel(new BorderLayout());
        panelCalendar.setBorder(BorderFactory.createLineBorder(Color.GRAY,1));

        JPanel panelHoras = new JPanel(new BorderLayout());
        panelHoras.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JPanel panelBoton = new JPanel(new GridLayout(1, 1, 10, 10));
        panelBoton.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));

        JPanel panelCombos = new JPanel(new GridLayout(2, 1, 5, 5));
        panelCombos.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel selecionaHora = crearLabels("Seleccione la hora: ");
        JLabel selecionaTratamiento = crearLabels("Seleccione tratamiento: ");

        JCalendar calendar = darEstiloCalendario();

        JComboBox<String> horas = new JComboBox<>();
        horas.addItem("8:00");
        horas.addItem("8:15");
        horas.addItem("8:30");
        horas.addItem("8:45");
        horas.addItem("9:00");
        horas.addItem("9:15");
        horas.addItem("9:30");
        horas.addItem("9:45");
        horas.addItem("10:00");
        horas.addItem("10:15");
        horas.addItem("10:30");
        horas.addItem("10:45");
        horas.addItem("11:00");
        horas.addItem("11:15");
        horas.addItem("11:30");
        horas.addItem("11:45");
        horas.addItem("12:00");
        horas.addItem("12:15");
        horas.addItem("12:30");
        horas.addItem("12:45");
        horas.addItem("13:00");
        horas.addItem("13:15");
        horas.addItem("13:30");
        horas.addItem("13:45");
        horas.addItem("14:00");
        horas.addItem("14:15");
        horas.addItem("14:30");
        horas.addItem("14:45");
        horas.addItem("15:00");
        horas.addItem("15:15");
        horas.addItem("15:30");
        horas.addItem("15:45");
        horas.addItem("16:00");

        DefaultComboBoxModel<Tratamiento> modeloTratamientos = cargarTratamientos();
        JComboBox<Tratamiento> comboTratamientos = new JComboBox<>(modeloTratamientos);


        JButton btnConfirmar = crearEstiloBoton("Confirmar Cita");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());
                String horaSeleccionada = (String) horas.getSelectedItem();

            }
        });

        panelCombos.add(selecionaTratamiento);
        panelCombos.add(comboTratamientos);
        panelCombos.add(selecionaHora);
        panelCombos.add(horas);

        panelBoton.add(btnConfirmar);

        panelCalendar.add(calendar, BorderLayout.CENTER);
        panelHoras.add(panelCombos, BorderLayout.CENTER);
        panelHoras.add(panelBoton, BorderLayout.SOUTH);

        panelPrincipal.add(panelCalendar, BorderLayout.CENTER);
        panelPrincipal.add(panelHoras, BorderLayout.SOUTH);

        return panelPrincipal;
    }

    private JPanel getjPanelBotonRetorno() {
        JPanel panelBotonRetorno = new JPanel(new BorderLayout());
        JButton botonRetorno = new JButton("←");
        panelBotonRetorno.add(botonRetorno, BorderLayout.SOUTH);
        panelBotonRetorno.setBorder(BorderFactory.createEmptyBorder(0, 20, 20, 320));
        panelBotonRetorno.setBackground(COLOR_FONDO_GRIS_CLARO);

        botonRetorno.setFocusPainted(false);
        botonRetorno.setBackground(COLOR_BOTON_GRIS_CLARO);
        botonRetorno.setFont(FUENTE_EMOJI);

        botonRetorno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfazDarCitaCliente().setVisible(true);
                dispose();
            }
        });
        return panelBotonRetorno;
    }

    private JCalendar darEstiloCalendario() {
        JCalendar calendar = new JCalendar();
        calendar.setWeekOfYearVisible(false);

        calendar.setDecorationBackgroundColor(Color.WHITE);
        calendar.setDecorationBordersVisible(true);

        calendar.setBackground(COLOR_FONDO_GRIS_CLARO);
        calendar.setForeground(Color.DARK_GRAY);

        JDayChooser dayChooser = calendar.getDayChooser();
        dayChooser.setWeekdayForeground(COLOR_BOTONES_AZUL);
        dayChooser.setSundayForeground(Color.RED);

        JMonthChooser monthChooser = calendar.getMonthChooser();
        monthChooser.setBackground(COLOR_FONDO_GRIS_CLARO);
        monthChooser.setForeground(COLOR_F);

        JYearChooser yearChooser = calendar.getYearChooser();
        yearChooser.setBackground(COLOR_FONDO_GRIS_CLARO);
        yearChooser.setForeground(COLOR_F);

        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        calendar.setFont(font);

        return calendar;

    }

    private JButton crearEstiloBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTONES);
        boton.setBackground(COLOR_BOTONES_AZUL);
        boton.setFocusPainted(false);
        boton.setForeground(Color.WHITE);
        boton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));
        return boton;
    }

    private JLabel crearLabels(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(FUENTE_LABEL);
        label.setPreferredSize(new Dimension(120, 30));

        return label;
    }

    public static void main(String[] args) {
        new InterfazGestionCita().setVisible(true);
    }
}
