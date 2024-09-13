package Ej2;

public class Animal {
    String sexo;

    public Animal(String sexo) {
        this.sexo = sexo;
    }

    public Animal() {
        this.sexo = "macho";
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "sexo='" + sexo + '\'' +
                '}';
    }
}
