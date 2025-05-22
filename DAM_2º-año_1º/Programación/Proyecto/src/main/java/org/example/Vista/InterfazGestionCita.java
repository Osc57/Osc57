package org.example.Vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import javax.swing.*;

import java.awt.*;

import static org.example.Vista.InterfazLogin.*;

public class InterfazGestionCita extends JFrame {

    private Color COLOR_F = new Color(50, 50, 50);

    public InterfazGestionCita(){
        this.setTitle("Dar Cita");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione fecha para el cliente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 0, 0));


        JPanel panelCalendario = getjPanelPanelCalendario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelCalendario, BorderLayout.CENTER);
    }

    private JPanel getjPanelPanelCalendario() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
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

        panelPrincipal.add(calendar, BorderLayout.CENTER);
        panelPrincipal.add(horas, BorderLayout.SOUTH);

        return panelPrincipal;
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

    public static void main(String[] args) {
        new InterfazGestionCita().setVisible(true);
    }
}
