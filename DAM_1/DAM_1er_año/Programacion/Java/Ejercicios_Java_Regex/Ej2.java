import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ej2 {
    public static void main(String[] args) {
        String texto = "IES SEGUNDO DE CHOMÓN\n" +
                "C/ Pablo Monguió, 48\n" +
                "44002 Teruel\n" +
                "Teléfono: 978 60 13 21\n" +
                "Fax: 978 60 00 80\n" +
                "Email: iesschteruel@educa.aragon.es\n" +
                "Web: www.iesch.org";

        String regexEmail = "[a-zA-Z0-9._%+-]+@[a-zA-Z.]+\\.[a-zA-Z]{2,}";
        String regexCodigoPostal = "\\d{5}";
        String regexTelefono = "\\d{3} \\d{2} \\d{2} \\d{2}";
        String regexWeb = "www\\.\\w{2,}\\.[a-zA-Z]{2,}";

        Pattern patternEmail = Pattern.compile(regexEmail);
        Matcher matcherEmail = patternEmail.matcher(texto);

        
        while (matcherEmail.find()){
            System.out.println("El correo electronico encontrado: " + matcherEmail.group());
        }

        Pattern patternCodigoPostal = Pattern.compile(regexCodigoPostal);
        Matcher matcherCodigoPostal = patternCodigoPostal.matcher(texto);

        while (matcherCodigoPostal.find()){
            System.out.println("El correo electronico encontrado: " + matcherCodigoPostal.group());
        }

        Pattern patternTelefono = Pattern.compile(regexTelefono);
        Matcher matcherTelefono = patternTelefono.matcher(texto);

        while (matcherTelefono.find()){
            System.out.println("El teléfono encontrado: " + matcherTelefono.group());
        }

        Pattern patternWeb = Pattern.compile(regexWeb);
        Matcher matcherWeb  = patternWeb.matcher(texto);

        while (matcherWeb.find()){
            System.out.println("La web encontrada: " + matcherWeb.group());
        }
    }
}
