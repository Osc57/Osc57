import java.util.HashMap;

public class Ej4 {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        hashMap.put("Cebra", 1);
        hashMap.put("Rinoceronte", 2);
        hashMap.put("Ornitorrinco", 3);
        hashMap.put("Leon", 4);

        System.out.println(hashMap);

        //Recupero valor de HashMap a partir de una clave
        int mamifero = hashMap.get("Rinoceronte");
        System.out.println("\t [+] El valor asociado a Rinoceronte es: " + mamifero);

        //Elimino entrada de HashMap y verifico que se ha eliminado
        hashMap.remove("Ornitorrinco");
        if (!hashMap.containsKey("Ornitorrinco")){
            System.out.println("La clave ha sido eliminada correctamente");
        }
        //Como se queda el HashMap al final
        System.out.println("Resultados: ");
        System.out.println(hashMap);

    }
}
