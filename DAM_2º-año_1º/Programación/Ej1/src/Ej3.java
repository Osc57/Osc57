//Realiza un programa y:
//a) Crea una variable entera llamada i que valga 3
//b) Crea una variable entera llamada j que valga el doble de i
//c) Crea una variable entera llamada k que valga el triple de j
//d) Cambia el valor de i por su valor dividido por 2
//e) Muestra por pantalla el valor de k
//f) Crea una variable entera llamada l que valga la mitad de 36
//g) Muestra por pantalla si k es igual a l
//h) Crea una variable booleana b con el resultado de comparar si k y l son iguales
//i) Asigna a k el valor cero
//j) Muestra por pantalla el valor de b
public class Ej3 {
    public static void main(String[] args) {
        int i = 3;
        int j = i*2;
        int k = j*3;
        i= i/2;
        System.out.println(k);
        int l = 36/2;
        System.out.println(k==l);
        boolean b = (k==l);
        k=0;
        System.out.println(b);
    }
}
