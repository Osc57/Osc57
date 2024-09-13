package TallerÓscarÚbeda;

import java.util.ArrayList;

public class Cliente extends POO.src.TallerÓscarÚbeda.Persona {
    int telefono;
    ArrayList<String>lista_vehiculos = new ArrayList<>();
    public Cliente(String DNI, String nombre, String apellido) {
        super(DNI, nombre, apellido);
    }

    public Cliente(String DNI, String nombre, String apellido, int telefono, ArrayList<String> lista_vehiculos) {
        super(DNI, nombre, apellido);
        this.telefono = telefono;
        this.lista_vehiculos = lista_vehiculos;
    }
}
