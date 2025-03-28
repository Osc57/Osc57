package Maquina;

import Interfaces.Identificacion;
import Utilidades.Comprobador;

public class Vehiculo implements Identificacion {
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo(String matricula) throws Exception {
        if (Comprobador.esValidaLaMatricula(matricula)){
            this.matricula = matricula;

        }else {
            throw  new Exception("Matricula Invalida");
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String identificate() {
        return "Soy un vehiculo. Mi marca es " + this.getMarca() + " modelo " + this.getModelo() + " matricula " + this.getMatricula();
    }
}
