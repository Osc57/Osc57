package org.example.Ej5;

/*
5. Ejercicio 5: Repetir los Ejercicios 1 y 2, pero esta vez serializar a XML usando JAXB.
*/

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Ej5 {
    public static void main(String[] args) {
        Book book = new Book("La Vuelta al Mundo en 80 días", "Julio Verne", 1873);

        try {
            JAXBContext context = JAXBContext.newInstance(Book.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, System.out);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
