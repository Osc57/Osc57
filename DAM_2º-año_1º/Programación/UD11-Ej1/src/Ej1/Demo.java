package Ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Demo extends Registro{
    public static void main(String[] args) {
        Registro registro = new Registro();

        String regexFrancia=".*,(FR),.*";
        String regexEmailYahoo = ".*,\\w+@yahoo.(\\w+.|\\w+),.*";

        Pattern patternEspanaPortugal = Pattern.compile(regexFrancia);
        Pattern patternEmailYahoo = Pattern.compile(regexEmailYahoo);

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader("DATA.csv"));){

            String linea  = null;
            while ((linea = bufferedReader.readLine()) != null){
                if (patternEspanaPortugal.matcher(linea).matches()){
                    registro.anadirFrancia(linea);
                }
                if (patternEmailYahoo.matcher(linea).matches()){
                    registro.anadirEmail(linea);
                }
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
