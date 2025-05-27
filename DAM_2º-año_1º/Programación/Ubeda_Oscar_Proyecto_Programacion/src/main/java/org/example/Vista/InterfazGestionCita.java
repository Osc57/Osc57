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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import static org.example.Controlador.ControladorCita.darCitaClientes;
import static org.example.Controlador.ControladorTratamientos.cargarTratamientos;
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
        panelCalendar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

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

        DefaultComboBoxModel<Tratamiento> modeloTratamientos = cargarTratamientos();//Metodo en Controlador Tratamientos
        JComboBox<Tratamiento> comboTratamientos = new JComboBox<>(modeloTratamientos);

        horas.setSelectedIndex(-1);
        comboTratamientos.setSelectedIndex(-1);
        JButton btnConfirmar = crearEstiloBoton("Confirmar Cita");
        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                confirmarCita(calendar, horas, comboTratamientos);

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

    private void confirmarCita(JCalendar calendar, JComboBox<String> horas, JComboBox<Tratamiento> tratamiento) {

        if (tratamiento.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione un tratamiento", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (horas.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(null, "Seleccione una hora", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Convertir la fecha seleccionada (Date → LocalDate)
            LocalDate fechaSeleccionada = calendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Obtener la fecha actual (sin hora)
            LocalDate fechaActual = LocalDate.now();

            // Validar que la cita no sea en un día anterior al actual
            if (fechaSeleccionada.isBefore(fechaActual)) {
                JOptionPane.showMessageDialog(null, "No se pueden asignar citas en días anteriores al actual.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Formatear fecha y hora para la base de datos (yyyy-MM-dd HH:mm:ss)
            String fechaFormateada = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getDate());
            String horaSeleccionada = (String) horas.getSelectedItem();
            String fechaHora = fechaFormateada + " " + horaSeleccionada + ":00";//Esto lo hago por el formato del date en la BBDD

            // Obtener datos del cliente y tratamiento
            String dniCliente = InterfazDarCitaCliente.obtenerDNICliente();
            Tratamiento tratamientoSeleccionado = (Tratamiento) tratamiento.getSelectedItem();
            int idTratamiento = tratamientoSeleccionado.getId();

            if (dniCliente != null) {
                // Intentar registrar la cita
                if (darCitaClientes(fechaHora, dniCliente, idTratamiento)) {
                    JOptionPane.showMessageDialog(null, "Cita asignada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new InterfazDarCitaCliente().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Hora ocupada: " + fechaHora + ". Por favor, elija otra hora.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }


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
}
