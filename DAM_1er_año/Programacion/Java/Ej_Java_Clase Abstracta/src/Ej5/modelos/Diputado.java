package Ej5.modelos;

public class Diputado {

    String nombre;
    String grupo;
    String provincia;
    String fechaAlta;
    String getFechaBaja;

    String lista;

    public Diputado() {
    }

    public Diputado(String nombre, String grupo, String provincia,String lista, String fechaAlta, String getFechaBaja) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.provincia = provincia;
        this.fechaAlta = fechaAlta;
        this.getFechaBaja = getFechaBaja;
        this.lista = lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getGetFechaBaja() {
        return getFechaBaja;
    }

    public void setGetFechaBaja(String getFechaBaja) {
        this.getFechaBaja = getFechaBaja;
    }

    public String getLista() {
        return lista;
    }

    public void setLista(String lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Diputado{" +
                "nombre='" + nombre + '\'' +
                ", grupo='" + grupo + '\'' +
                ", provincia='" + provincia + '\'' +
                ", fechaAlta='" + fechaAlta + '\'' +
                ", getFechaBaja='" + getFechaBaja + '\'' +
                ", lista='" + lista + '\'' +
                '}';
    }
}
