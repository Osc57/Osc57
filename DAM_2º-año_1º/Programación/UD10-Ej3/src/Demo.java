import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        Secretario secretario = new Secretario("Agustin","Peréz","11111111R","C/Direccion",977777777,1500, true, 78421888);
        Vendedor vendedor = new Vendedor("Manolo","Lama","22222222E", "C/La calle", 444444444, 1850, "4455KLK","Suzuki","Vitara",555555555,"España");

        System.out.println(secretario.imprimir());
        secretario.incrementarSalario();
        System.out.println(secretario.imprimir());

        System.out.println(vendedor.imprimir());
        vendedor.incrementarSalario();
        System.out.println(vendedor.imprimir());

        System.out.println(vendedor.cambiarDeCoche("1458KYT","Mercedes","Benz"));
        System.out.println(vendedor.imprimir());
    }
}
