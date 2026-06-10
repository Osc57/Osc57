package org.example.Ej1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ej1_json {
    public static void main(String[] args) {
        ArrayList<Persona> personas = new ArrayList<>();

        Persona persona1 = new Persona("Persona", 23, "Casa");
        Persona persona2 = new Persona("Persona2", 17, "Casa");
        Persona persona3 = new Persona("Persona4", 43, "Casa");

        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File("personas.json"), personas);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
