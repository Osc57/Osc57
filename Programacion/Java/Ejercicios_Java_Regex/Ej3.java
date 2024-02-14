import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class Ej3 {
    public static void main(String[] args) {

        String ruta = "data/DATA.csv";
        BufferedReader reader = null;

        String regexEspanaPortual=".*,(ES|PT),.*";
        String regexEmailEdu=".*,\\w+@\\w+.edu,.*";
        String regexEmailYahoo = ".*,\\w+@yahoo.(\\w+.|\\w+),.*";


        Pattern patternEspanaPortugal = Pattern.compile(regexEspanaPortual);
        Pattern patternEmailEdu = Pattern.compile(regexEmailEdu);
        Pattern patternEmailYahoo = Pattern.compile(regexEmailYahoo);

        LocalDate fechaInicio = LocalDate.of(2015,5,1);
        LocalDate fechaFinal = LocalDate.of(2017,2,1);

        String linea = null;
        try {
            reader = new BufferedReader(new FileReader(ruta));
            linea = reader.readLine();

            while ((linea = reader.readLine()) != null){

                if (patternEspanaPortugal.matcher(linea).matches()){
                    System.out.println("ES|PT: " + linea);
                }
                if (patternEmailEdu.matcher(linea).matches()){
                    System.out.println("Email edu: " + linea);
                }
                if (patternEmailYahoo.matcher(linea).matches()){
                    System.out.println("Email Yahoo: " + linea);
                }

                //Sin expresión regular, comparación fechas.
                String[] fila = linea.split(",");
                LocalDate fechaLogin = LocalDate.parse(fila[9].split("")[0]);
                if ((fechaLogin.isAfter(fechaInicio)) && fechaLogin.isBefore(fechaFinal)){
                    System.out.println("FechaLogin: " + linea);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
