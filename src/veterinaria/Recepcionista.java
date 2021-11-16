package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Recepcionista extends Persona implements Serializable {

    private StockProductos sp;
    private ArrayList<Veterinario> veterinarios;

    public Recepcionista(String usuario, String password) {
        setUsuario(usuario);
        setPassword(password);
    }

    public StockProductos getSp() {
        return sp;
    }

    public void setSp(StockProductos sp) {
        this.sp = sp;
    }

    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(ArrayList<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    public String mostrarListaVeterinarios() {
        String lista = "";
        if (veterinarios != null) {
            for (int i = 0; i < veterinarios.size(); i++) {
                lista += "[" + (i + 1) + "] " + veterinarios.get(i) + "\n";
            }
        } else {
            lista = "No hay veterinarios para atenteder pacientes";
        }
        return lista;
    }

    public void otorgaTurno() {
        String nomMascota, nomDueño, contacto;
        int op, tipo;
        nomMascota = EntradaSalida.leerString("Nombre de paciente (mascota)");
        nomDueño = EntradaSalida.leerString("Nombre Dueño");
        contacto = EntradaSalida.leerString("Número de contacto");
        tipo = EntradaSalida.leerInt("Tipo de animal\n\n[1] Gato\n[2] Perro\n[3] Tortuga/Canario");
        Mascota mascota = new Mascota(nomMascota, nomDueño, contacto, tipo);
        do {
            op = EntradaSalida.leerInt(
                    " ASIGNAR PACIENTE A VETERINARIO\n"
                    + "ESPECIALIDAD: (1) Gato - (2) Perro - (3) Tortuga/Canario\n\n"
                    + "[0] SALIR\n"
                    + mostrarListaVeterinarios());
        } while (op < 0 || op > veterinarios.size());
        if (op != 0 && veterinarios.get(op - 1).getEspecialidad() == mascota.getTipo()) {
            Fecha fecha = new Fecha();
            int dia, mes, anio, diaFecha;
            boolean existe = false;
            String fechaComp;
            dia = EntradaSalida.leerInt("Verificar fecha a asignar\n\nIngrese día");
            mes = EntradaSalida.leerInt("Verificar fecha a asignar\n\nIngrese mes");
            anio = EntradaSalida.leerInt("Verificar fecha a asignar\n\nIngrese año");
            diaFecha = fecha.diaSemana(dia, mes, anio);
            fechaComp = dia + "-" + mes + "-" + anio;
            if (fecha.comparaFecha(fechaComp, fecha.devuelveFecha()) == 1) {
                for (int i = 0; i < 3; i++) {
                    if (diaFecha == veterinarios.get(op - 1).getDias().get(i)) {
                        existe = true;
                    }
                }
                if (existe) {
                    String hora = EntradaSalida.leerString("FECHA DISPONIBLE\n\nHorario 9:00 a 18:00  Intervalos de 30 min\nIngrese el inicio de hora de consulta");
                    Turno turno = new Turno(dia + "/" + mes + "/" + anio + "  hora: " + hora, mascota, veterinarios.get(op - 1));
                    turno.getTurnos().add(turno);
                    veterinarios.get(op - 1).getAgenda().getTurnos().add(turno);
                    EntradaSalida.mostrarString("Turno agendado correctamente");
                } else {
                    EntradaSalida.mostrarString("El veterinario no atiende en la fecha indicada");
                }
            } else {
                EntradaSalida.mostrarString("ERROR\n\nIngresó una fecha inválida, la fecha debe ser posterior");
            }
        } else {
            EntradaSalida.mostrarString("ATENCIÓN\nEl tipo de mascota no corresponde con la\nespecialidad del veterinario");
        }

    }

    private void vendeProducto() {
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
                if (op != 0 && sp.getProductos().get(op - 1).getCategoria().equalsIgnoreCase("r")) {
                    EntradaSalida.mostrarString("Venta exitosa!!");
                } else {
                    EntradaSalida.mostrarString("ATENCIÓN\nUsted no esta autorizado(a) a vender este producto");
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

    @Override
    public boolean proceder() {
        boolean cerrar = false;
        while (!cerrar) {
            int op;
            do {
                op = EntradaSalida.leerInt(
                        "RECEPCIÓN - VETERINARIA THE EVIL PET\n\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Vender producto\n"
                        + "[3] Otorgar Turno\n");
            } while (op < 1 || op > 3);
            if (op != 0 && op != 1) {
                switch (op) {
                    case 2:
                        vendeProducto();
                        break;
                    case 3:
                        otorgaTurno();
                        break;
                }
            } else if (op == 1) {
                EntradaSalida.mostrarString("Hasta pronto!");
                cerrar = true;
            }
        }
        return cerrar;
    }

}
