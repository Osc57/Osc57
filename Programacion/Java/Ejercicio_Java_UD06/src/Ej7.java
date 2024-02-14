import java.util.Random;

public class Ej7 {
    public static void main(String[] args) {

        Random random = new Random();
        //números entre el 65 y el 90
        int codigoAscii_A = 65;
        int codigoAscii_Z = 90;
        int numeroAleatorioC = (int)(Math.random() * (codigoAscii_Z - codigoAscii_A + 1) + codigoAscii_A);
        System.out.println(numeroAleatorioC);
        char letra = (char) numeroAleatorioC;
        System.out.println(letra);
        System.out.println("<--------------------->");
        int numeroAscii = (int) 'C';
        System.out.println(numeroAscii);

        if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U'){
            System.out.println("La letra " + letra + " es una vocal");
        }


    }
}
