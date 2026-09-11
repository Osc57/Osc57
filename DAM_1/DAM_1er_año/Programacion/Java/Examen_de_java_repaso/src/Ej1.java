import java.util.*;

public class Ej1 {
    public static void main(String[] args) {
        Map<Integer, Integer>listanumeros = new HashMap<>();
        Random random = new Random();


        for (int i = 0; i < 40; i++) {
            int numero_aleatorio = random.nextInt(50);
            int valorAntiguo = listanumeros.getOrDefault(numero_aleatorio, 0);
            listanumeros.put(numero_aleatorio, (valorAntiguo+1));
        }

        List<Numero>lista = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entrada: listanumeros.entrySet()){
            int numero = entrada.getKey();
            int veces = entrada.getValue();

            lista.add(new Numero(numero,veces));
        }

        Collections.sort(lista);
        System.out.println(lista);

    }
}

class Numero implements Comparable{
    int numero;
    int veces;

    public Numero() {
    }

    public Numero(int numero, int veces) {
        this.numero = numero;
        this.veces = veces;
    }

    @Override
    public String toString() {
        return "El número " + numero + " aparece " + veces + " veces \n" ;
    }

    @Override
    public int compareTo(Object o) {
        Numero otroNumero= (Numero) o;
        if (this.veces < otroNumero.veces){
            return  -1;
        } else if (this.veces < otroNumero.veces) {
            return  0;

        }else return 0;
    }
}
