//Realiza un programa con una variable entera t la cual contiene un tiempo en segundos
//y queremos conocer este tiempo expresado en horas, minutos y segundos.
public class Ej14 {
    public static void main(String[] args) {
        int t = 3665;

        int horas = t/3600;
        int min = (t%3600)/60;
        int segundos = (t%3600)%60;

        System.out.println("Las horas son: "+horas+", Los minutos son: "+min+", Los segundos son: "+segundos);
    }
}
