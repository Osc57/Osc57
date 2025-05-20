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
        JPanel panelPrincipal = new JPanel(new GridLayout(1,1,0,0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JCalendar calendar = darEstiloCalendario();



        panelPrincipal.add(calendar, BorderLayout.CENTER);

        return panelPrincipal;
    }

    private JCalendar darEstiloCalendario() {
        JCalendar calendar = new JCalendar();
        calendar.setWeekOfYearVisible(false);

        calendar.setDecorationBackgroundColor(Color.WHITE);
        calendar.setDecorationBordersVisible(true);

        // Cambiar colores
        calendar.setBackground(COLOR_FONDO_GRIS_CLARO);
        calendar.setForeground(Color.DARK_GRAY);

        // Personalizar el header
        JDayChooser dayChooser = calendar.getDayChooser();
        dayChooser.setWeekdayForeground(COLOR_BOTONES_AZUL);
        dayChooser.setSundayForeground(Color.RED);

        // Personalizar el mes y año
        JMonthChooser monthChooser = calendar.getMonthChooser();
        monthChooser.setBackground(COLOR_FONDO_GRIS_CLARO);
        monthChooser.setForeground(COLOR_F);

        // Personalizar el año
        JYearChooser yearChooser = calendar.getYearChooser();
        yearChooser.setBackground(COLOR_FONDO_GRIS_CLARO);
        yearChooser.setForeground(COLOR_F);

        // Ocultar botones de navegación si se desea
        //calendar.setNullDateButtonVisible(false);

        // Cambiar la fuente
        Font font = new Font("Segoe UI", Font.PLAIN, 12);
        calendar.setFont(font);

        return calendar;

    }

    public static void main(String[] args) {
        new InterfazGestionCita().setVisible(true);
    }
}
