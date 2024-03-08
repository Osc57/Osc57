package Ej5.modelos;

public class Diputado {

    String nombre;
    String grupo;
    String provincia;
    String fechaAlta;
    String getFechaBaja;

    public Diputado() {
    }

    public Diputado(String nombre, String grupo, String provincia, String fechaAlta, String getFechaBaja) {
        this.nombre = nombre;
        this.grupo = grupo;
        this.provincia = provincia;
        this.fechaAlta = fechaAlta;
        this.getFechaBaja = getFechaBaja;
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
}
