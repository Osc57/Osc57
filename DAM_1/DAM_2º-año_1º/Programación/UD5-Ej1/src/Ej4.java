/**
 * Crea un array con los valores “variables”, “literales”, “constantes”,
 * “expresiones”, “métodos”, “bloques” y “excepciones”.
 * **/
public class Ej4 {
    public static void main(String[] args) {
        String [] valores = {"variables","literales","constantes","expresiones", "métodos", "bloques", "excepciones"};

        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + ", ");
        }
    }
}
