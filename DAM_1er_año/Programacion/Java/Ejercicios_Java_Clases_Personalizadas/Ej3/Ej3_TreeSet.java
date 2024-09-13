package Ej3;

import java.util.TreeSet;

public class Ej3_TreeSet {
    public static void main(String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<>();

        treeSet.add(new Employee(1,"Juan",3000F));
        treeSet.add(new Employee(2,"Pablo",1200F));
        treeSet.add(new Employee(3,"David",1500F));
        treeSet.add(new Employee(4,"Maria",3500F));
        //Mostrar los empleados por orden de salario
        for (Employee employee : treeSet){
            System.out.println(employee);
        }
    }
}
