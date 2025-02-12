public abstract class Empleado {
    private String nombre;
    private String apellidos;
    private String dni;
    private String direccion;
    private int anosAntiguedad;
    private int telefContacto;
    protected double salario;
    private Empleado supervisor;

    public Empleado(String nombre, String apellidos, String dni, String direccion, int telefContacto, double salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion = direccion;
        this.telefContacto = telefContacto;
        this.salario = salario;
    }

    public abstract double incrementarSalario();


    public Empleado cambiarSupervisor(Empleado nuevoSupervisor){
        return this.supervisor = nuevoSupervisor;
    }

    public String imprimir(){
        return "Nombre: " + nombre + ", Apellidos: " + apellidos + ", Dni: " + dni +
                ", Dirección: " + direccion + ", Teléfono: " + telefContacto + ", Salario: " + salario;
    }
}
