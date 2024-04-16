package org.iesch.Ej_5;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Ej_1y2 {
    public static void main(String[] args) {
        Book libro1 = new Book("La medida de lo posible", "Aurelio Vals", 1875);
        try {

            JAXBContext context = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(libro1, new File("ej5.xml"));


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
