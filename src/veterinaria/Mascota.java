package veterinaria;

import java.io.Serializable;

public class Mascota implements Serializable {

    private String nomMascota;
    private String nomDueño;
    private String numContacto;
    private int tipo;

    public Mascota(String nomMascota, String nomDueño, String numContacto, int tipo) {
        this.nomMascota = nomMascota;
        this.nomDueño = nomDueño;
        this.numContacto = numContacto;
        this.tipo = tipo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNomMascota() {
        return nomMascota;
    }

    public void setNomMascota(String nomMascota) {
        this.nomMascota = nomMascota;
    }

    public String getNomDueño() {
        return nomDueño;
    }

    public void setNomDueño(String nomDueño) {
        this.nomDueño = nomDueño;
    }

    public String getNumContacto() {
        return numContacto;
    }

    public void setNumContacto(String numContacto) {
        this.numContacto = numContacto;
    }

    @Override
    public String toString() {
        return  nomMascota;
    }
    
}
