package Maquina;

public class Moto extends Vehiculo{
    private boolean limitador;

    public Moto(String matricula) throws Exception {
        super(matricula);
    }

    public boolean isLimitador() {
        return limitador;
    }

    public void setLimitador(boolean limitador) {
        this.limitador = limitador;
    }
    @Override
    public String identificate(){
        return "Soy una moto, mi matricula es " +  super.getMatricula();
    }
}
