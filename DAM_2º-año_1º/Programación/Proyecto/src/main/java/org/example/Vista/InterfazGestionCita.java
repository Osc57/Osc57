package org.example.Vista;

import com.toedter.calendar.JCalendar;

import javax.swing.*;

import java.awt.*;

import static org.example.Vista.InterfazLogin.FUENTE_TITULO_2;
import static org.example.Vista.InterfazLogin.configurarCierreVentana;

public class InterfazGestionCita extends JFrame {

    public InterfazGestionCita(){
        this.setTitle("Dar Cita");
        this.setSize(460, 460);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configurarCierreVentana(this);

        JLabel introducirCliente = new JLabel("•Seleccione fecha para el cliente");
        introducirCliente.setFont(FUENTE_TITULO_2);
        introducirCliente.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 0));


        JPanel panelCalendario = getjPanelPanelCalendario();

        this.add(introducirCliente, BorderLayout.NORTH);
        this.add(panelCalendario, BorderLayout.CENTER);
    }

    private JPanel getjPanelPanelCalendario() {
        JPanel panelPrincipal = new JPanel(new GridLayout(1,1,0,0));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JCalendar calendar = new JCalendar();
        calendar.setWeekOfYearVisible(false);


        panelPrincipal.add(calendar, BorderLayout.CENTER);

        return panelPrincipal;
    }
    public static void main(String[] args) {
        new InterfazGestionCita().setVisible(true);
    }
}
