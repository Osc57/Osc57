package org.example.SerializacionDeserealizacion.Ej1;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;

/**
 *  Crea una clase Persona con atributos nombre, edad y correo.
 *  Usa Jackson para convertir el objeto a JSON y guardarlo en un archivo.
 *  Usa JAXB para convertirlo a XML y guardarlo.
 *  Luego, deserializa los archivos y verifica que los datos sean correctos.
 **/

public class Ej1 {
    public static void main(String[] args) {
        Persona persona = new Persona("Manolo", 17, "manolo123@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(persona);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("Persona.json").toFile(), persona);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Persona.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persona, new File("Persona.xml"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
