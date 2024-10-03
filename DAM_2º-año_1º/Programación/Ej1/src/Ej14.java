//Realiza un programa con una variable entera t la cual contiene un tiempo en segundos
//y queremos conocer este tiempo expresado en horas, minutos y segundos.
public class Ej14 {
    public static void main(String[] args) {
        int t = 25000;

        int min = t/60;
        int horas = min/60;

        System.out.println("Las horas son: "+horas+", Los minutos son: "+min+", Los segundos son: "+t);
    }
}
