public class Demo {
    public static void main(String[] args) {
        Empleado secretario = new Secretario("Agustin","Peréz","11111111R","C/Direccion",977777777,1500, true, 78421888);
        Empleado vendedor = new Vendedor("Manolo","Lama","22222222R","C/Calle",111111111,1850,"1234GRG","Suzuki","Vitara");


        System.out.println(secretario.imprimir());
        secretario.incrementarSalario();
        System.out.println(secretario.imprimir());

        System.out.println(vendedor.imprimir());
        vendedor.incrementarSalario();
        System.out.println(vendedor.imprimir());

    }
}
