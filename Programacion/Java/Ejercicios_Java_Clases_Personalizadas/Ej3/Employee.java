package Ej3;

public class Employee implements Comparable{
    int id;
    String name;
    Float salary;

    public Employee() {
    }

    public Employee(int id, String name, Float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public  int compareTo(Object o){
        Employee employee = (Employee) o;
        if (this.salary < employee.salary){
            return -1;
        } else if (this.salary == employee.salary) {
            return 0;
        }else
            return 1;
    }
}
