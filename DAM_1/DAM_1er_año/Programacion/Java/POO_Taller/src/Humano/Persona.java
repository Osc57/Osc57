package Humano;

import Interfaces.Identificacion;
import Utilidades.Comprobador;

public class Persona implements Identificacion{

    private String dni;
    private String nombre;

    @Override
    public String identificate(){
        return "Soy persona, mi DNI es" + this.getDni() + ", mi nombre es " + this.getNombre();
    }

    public Persona(String dni, String nombre) throws Exception {
        if (Comprobador.esValidoDNI(dni)){
            this.dni=dni;
        }else {
            throw new Exception("El DNI es incorrecto");
        }
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws Exception {
        if (Comprobador.esValidoDNI(dni)){
            this.dni=dni;
        }else {
            throw new Exception("El DNI es incorrecto");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
