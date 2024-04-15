package org.iesch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
      Coche coche1 = new Coche();

      coche1.setMarca("BMW");
      coche1.setModelo("320d");
      coche1.setColor("Negro");
      coche1.setMatricula("1516 BJH");

      System.out.println(coche1.toString());

      ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = objectMapper.writeValueAsString(coche1);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}