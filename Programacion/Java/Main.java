import java.io.*;

public class Main {
    public static void main(String[] args) {
        String ruta = "./Equipos";
        

        File r_movistar = new File("./Equipos/Movistar.txt");
        File r_visma = new File("./Equipos/TeamVisma.txt");
        File r_emirates= new File("./Equipos/UAE Team Emirates.txt");


        try {
            FileReader movistar = new FileReader(r_movistar);
            FileReader visma = new FileReader(r_visma);
            FileReader emirates = new FileReader(r_emirates);

            BufferedReader br_movistar = new BufferedReader(movistar);
            BufferedReader br_visma = new BufferedReader(visma);
            BufferedReader br_emirates = new BufferedReader(emirates);

            System.out.println(" ");
            System.out.println("TEAM MOVISTAR: ");
            int contador_movistar = 0;
            while ((br_movistar.readLine()) != null) {
                contador_movistar = contador_movistar + 1;
            }
            System.out.println("Ciclistas: " + contador_movistar);

            System.out.println(" ");
            System.out.println("TEAM VISMA:");
            int contador_visma = 0;
            while ((br_visma.readLine()) != null) {
                contador_visma = contador_visma + 1;
            }
            System.out.println("Ciclistas: " + contador_visma);

            System.out.println(" ");
            System.out.println("TEAM UAE EMIRATES: ");
            int contador_emirates = 0;
            while ((br_emirates.readLine()) != null) {
                contador_emirates = contador_emirates +1;

            }
            System.out.println("Ciclistas: " + contador_emirates);

            br_movistar.close();
            br_visma.close();
            br_emirates.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
