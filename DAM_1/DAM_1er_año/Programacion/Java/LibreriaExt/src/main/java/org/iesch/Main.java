package org.iesch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {
    public static void main(String[] args) {
      Coche coche1 = new Coche();

      coche1.setMarca("BMW");
      coche1.setModelo("320d");
      coche1.setColor("Negro");
      coche1.setMatricula("1516 BJH");

      System.out.println(coche1.toString());

     /* ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(coche1);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
     */
       /* try {
            JAXBContext context = JAXBContext.newInstance(Coche.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //imprimimos por pantalla
            marshaller.marshal(coche1, System.out);

        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }*/
        try {
            File archivo = new File("CocheXML.xml");
            JAXBContext context = JAXBContext.newInstance(Coche.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Coche coche = (Coche) unmarshaller.unmarshal(archivo);
            System.out.println(coche);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}