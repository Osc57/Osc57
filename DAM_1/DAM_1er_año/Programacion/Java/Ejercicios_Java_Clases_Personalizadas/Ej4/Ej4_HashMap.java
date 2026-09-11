package Ej4;

import java.util.HashMap;
import Ej1.Student;

public class Ej4_HashMap {
    public static void main(String[] args) {
        HashMap<Integer, Student>  studentHashMap = new HashMap<Integer, Student>();
        studentHashMap.put(1, new Student(1, "Juan", "Informática"));
        studentHashMap.put(2, new Student(2, "Pablo", "Biología"));
        studentHashMap.put(3, new Student(3, "Toni", "Mecánica"));
        studentHashMap.put(4, new Student(4, "Iker", "Medicina Forense"));

        for (Integer id : studentHashMap.keySet()){
            System.out.println("Clave: " + id + "Valor: " + studentHashMap.get(id));
        }
    }
}
