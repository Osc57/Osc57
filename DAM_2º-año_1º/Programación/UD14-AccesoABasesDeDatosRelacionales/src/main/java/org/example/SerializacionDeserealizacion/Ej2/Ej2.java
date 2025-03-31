package org.example.SerializacionDeserealizacion.Ej2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.SerializacionDeserealizacion.Ej1.Persona;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Define una clase Producto con atributos id, nombre y precio.
 *  Crea una lista de objetos Producto y conviértela a JSON y XML.
 *  Guarda los archivos y recupéralos deserializando su contenido.
 **/

public class Ej2 {
    public static void main(String[] args) {
        List<Producto> listaProducto = Arrays.asList(new Producto(1, "Batidora", 39.99),
                new Producto(2, "Taladro", 49.99),
                new Producto(3, "Martillo", 14.99));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(listaProducto);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("Producto.json").toFile(), listaProducto);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Productos.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(new Productos(listaProducto), new File("Producto.xml"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
