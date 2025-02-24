package Ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Demo extends Registro{
    public static void main(String[] args) {
        Registro registro = new Registro();

        String regexEspanaPortual=".*,(ES|PT),.*";
        String regexEmailYahoo = ".*,\\w+@yahoo.(\\w+.|\\w+),.*";

        Pattern patternEspanaPortugal = Pattern.compile(regexEspanaPortual);
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
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
