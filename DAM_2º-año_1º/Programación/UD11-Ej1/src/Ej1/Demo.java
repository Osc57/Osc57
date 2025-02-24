package Ej1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo extends Registro{
    public static void main(String[] args) {

        try ( BufferedReader bufferedReader = new BufferedReader(new FileReader("DATA.csv"));){

            String linea;
            while ((linea = bufferedReader.readLine()) != null){
                
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
