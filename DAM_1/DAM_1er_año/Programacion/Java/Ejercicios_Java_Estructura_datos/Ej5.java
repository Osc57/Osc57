import java.util.TreeMap;

public class Ej5 {
    public static void main(String[] args) {
        TreeMap<String,Integer> treeMap = new TreeMap<>();

        treeMap.put("Rojo", 1);
        treeMap.put("Verde", 2);
        treeMap.put("Azul", 3);
        treeMap.put("Amarillo", 4);//Ordena alfabéticamente por la clave
        treeMap.put("Morado", 5);

        System.out.println(treeMap);

        //Recupero valor de TreeMap a partir de una clave
        int color = treeMap.get("Azul");
        System.out.println("\t [+] El valor asociado a Azul es: " + color);

        //Elimino entrada de TreeMap y verifico que se ha eliminado
        treeMap.remove("Azul");
        if (!treeMap.containsKey("Azul")){
            System.out.println("La clave ha sido eliminada correctamente");
            System.out.println(treeMap);
        }

    }
}
