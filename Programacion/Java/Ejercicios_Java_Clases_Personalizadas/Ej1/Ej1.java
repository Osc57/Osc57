package Ej1;

import java.util.ArrayList;

public class Ej1 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Juan", "Informática"));
        students.add(new Student(2, "Pepe", "Literatura y letras"));
        students.add(new Student(3, "Antonio", "Biología"));

        for (Student student : students){
            System.out.println(student);
        }
    }
}
