package Ej2;

import java.util.Random;

public class Gato extends Animal{
    String raza;

    public Gato(){
        super("hembra");
        this.raza="siamés";
    }

    public Gato(String raza) {
        super("hembra");
        this.raza = raza;
    }

    /*public Gato(String sexo) {
        super(sexo);

    }*/

    public Gato(String sexo, String raza) {
        super(sexo);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "raza='" + raza + '\'' +
                '}';
    }

    public  Gato apraeaCon(Gato gato) throws ApareamentoImposibleException{
       if (this.sexo.equals(gato.sexo)){
           throw new ApareamentoImposibleException("Los gatos deben ser de diferente sexo");
       }
       String sexoCria = new Random().nextBoolean() ? "macho" : "hembra";
       return new Gato(sexoCria, this.raza);
    }

    public static void main(String[] args) {
        Gato gato1 = new Gato("macho","persa");
        Gato gato2 = new Gato("hembra","persa");
        try {
            Gato gato = gato1.apraeaCon(gato2);
            System.out.println(gato);
        }catch (ApareamentoImposibleException e){
            e.printStackTrace();
        }
    }
}
