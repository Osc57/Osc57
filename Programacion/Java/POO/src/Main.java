import ClaseAbstracta.Bicicleta;
import Clases.BiciMontania;
import Clases.BiciPaseo;
import Clases.Tandem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Bicicleta>listaDeBicicletas = new ArrayList<>();
    public static void main(String[] args) {

        BiciMontania bm1 = new BiciMontania("rojo", 1500, 6);
        BiciMontania bm2 = new BiciMontania("azul", 1800, 2);

        BiciPaseo biciPaseo = new BiciPaseo("amarillo", 1200, 0);

        Tandem tandem1 = new Tandem("verde", 3599, 2);
        Tandem tandem2 = new Tandem("verde", 5999, 3);

        listaDeBicicletas.add(bm1);
        listaDeBicicletas.add(bm2);
        listaDeBicicletas.add(biciPaseo);
        listaDeBicicletas.add(tandem1);
        listaDeBicicletas.add(tandem2);

        bm1.aumentarMarcha();
        bm2.bajarMarcha();

        System.out.println(listaDeBicicletas.toString());

    }
}
