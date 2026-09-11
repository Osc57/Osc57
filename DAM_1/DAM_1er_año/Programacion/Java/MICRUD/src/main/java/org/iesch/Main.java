package org.iesch;


import org.iesch.bbdd.DatabaseCRUD;
import org.iesch.modelos.Persona;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        DatabaseCRUD bdcrud = new DatabaseCRUD();

        //READ
        List<Persona> listPersonas = bdcrud.obtenerTodo();
        System.out.println(listPersonas);

        //INSERT
        Persona persona = new Persona(18446777,"Antonio","Lopez","poco",180,70.5F);
        bdcrud.inserta(persona);

        //DELETE
        /*Persona persona1 = new Persona();
        persona1.setDni("99");
        bdcrud.borra(persona1);*/

        //UPDATE
        /*Persona persona = new Persona("18446777A","Pedro","Sanchez","Hombre",183,79.5F);
        bdcrud.actualiza(persona);*/
    }
}
