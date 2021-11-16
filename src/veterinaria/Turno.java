package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Turno implements Serializable {

    private String fechaHora;
    private Mascota mascota;
    private Veterinario veterinario;
    private ArrayList<Turno> turnos;

    public Turno(String fechaHora, Mascota mascota, Veterinario veterinario) {
        this.fechaHora = fechaHora;
        this.mascota = mascota;
        this.veterinario = veterinario;
        turnos = new ArrayList<>();
    }

    public Turno(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public String listaTurnos() {
        String lista = "";
        for (int i = 0; i < turnos.size(); i++) {
            lista += "[" + (i + 1) + "] " + turnos.get(i) + "\n";
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Fecha: " + fechaHora + ",  mascota: " + mascota;
    }

}
