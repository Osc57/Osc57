import java.io.*;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file = new File("./documento");
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            System.out.println("Este es el archivo actual");
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = "";
            while ((linea = bufferedReader.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.print("Quieres escribir en el (Y/N): ");
            String si_no = scanner.nextLine();

            if (si_no.equals("Y") || si_no.equals("y")){
                System.out.print("Que frase quieres escribir en el documento: ");
                String frase = scanner.nextLine();
                bufferedReader.close();
                bufferedWriter = new BufferedWriter(new FileWriter(file, true));
                bufferedWriter.write("\n" + frase);

            } else if (si_no.equals("N") || si_no.equals("n")) {
                System.out.println("Has decidido no escribir en el archivo");
            }else {
                System.out.println("Algo ha salido mal");
            }
        } catch (IOException e) {
            System.out.println("La frase se ha añadido correctamente");

        }finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }

        }
    }
}