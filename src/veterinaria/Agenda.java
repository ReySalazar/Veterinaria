package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author REY
 */
public class Agenda implements Serializable {

    private List<Turno> turnos;

    public Agenda() {
        turnos = new ArrayList<>();
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void agregarTurno(Turno turno) {
        this.turnos.add(turno);
    }

    public String mostrarAgenda() {
        String lista = "";
        for (int i = 0; i < turnos.size(); i++) {
            lista += "[" + (i + 1) + "] " + turnos.get(i) + "\n";
        }
        return lista;
    }

}
