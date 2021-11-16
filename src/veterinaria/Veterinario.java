package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Veterinario extends Persona implements Serializable {

    private StockProductos sp;
    private int especialidad;
    private ArrayList<Integer> dias = new ArrayList<>();
    private Agenda agenda;

    public Veterinario(String usuario, String password, int especialidad, ArrayList dias) {
        setUsuario(usuario);
        setPassword(password);
        this.dias = dias;
        this.especialidad = especialidad;
        agenda = new Agenda();
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }

    public StockProductos getSp() {
        return sp;
    }

    public void setSp(StockProductos sp) {
        this.sp = sp;
    }

    public ArrayList<Integer> getDias() {
        return dias;
    }

    public void setDias(ArrayList<Integer> dias) {
        this.dias = dias;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public void vendeProducto() {
        int op;
        boolean cerrar = false;
        if (sp.getProductos().size() > 0) {
            while (!cerrar) {
                do {
                    op = EntradaSalida.leerInt(
                            "   PRODUCTOS\n\n"
                            + "[0] SALIR\n"
                            + sp.mostrarProductos());
                } while (op < 0 || op > sp.getProductos().size());
                if (op != 0) {
                    EntradaSalida.mostrarString("Venta exitosa!!");
                }
                char c = EntradaSalida.leerChar("Seguir Vendiendo (S/N)");
                if (c == 'N' || c == 'n') {
                    cerrar = true;
                }
            }
        } else {
            EntradaSalida.mostrarString("ATENCIÓN\nNo hay productos cargados en el stock");
        }
    }

    public void atiendeMascota() {
        if (agenda.getTurnos().size() > 0) {
            EntradaSalida.mostrarString("---- AGENDA -----\n\n"
                    + "Actualmente tiene agendado/asignado los siguientes turnos\n"
                    + agenda.mostrarAgenda());
        } else {
            EntradaSalida.mostrarString("DISCULPE\n\nNo tiene turnos agendados/asignados");
        }
    }

    @Override
    public boolean proceder() {
        boolean cerrar = false;
        while (!cerrar) {
            int op;
            do {
                op = EntradaSalida.leerInt(
                        "MENÚ VETERINARIO - VETERINARIA THE EVIL PET\n\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Vender producto\n"
                        + "[3] Atención pacientes asignados\n");
            } while (op < 1 || op > 3);
            if (op != 0 && op != 1) {
                switch (op) {
                    case 2:
                        vendeProducto();
                        break;
                    case 3:
                        atiendeMascota();
                        break;
                }
            } else if (op == 1) {
                EntradaSalida.mostrarString("Hasta pronto!");
                cerrar = true;
            }
        }
        return cerrar;
    }

    @Override
    public String toString() {
        return "Veterinario " + getUsuario() + "  Especialidad : " + especialidad;
    }

}
