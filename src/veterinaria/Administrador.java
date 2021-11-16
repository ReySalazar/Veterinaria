package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class Administrador extends Persona implements Serializable {

    private StockProductos sp;
    private ArrayList<Persona> personas;
    private ArrayList<Veterinario> veterinarios;

    public Administrador(String usuario, String password) {
        setUsuario(usuario);
        setPassword(password);
        sp = new StockProductos();
        veterinarios = new ArrayList<>();
    }

    public StockProductos getSp() {
        return sp;
    }

    public void setSp(StockProductos sp) {
        this.sp = sp;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public ArrayList<Veterinario> getVeterinarios() {
        return veterinarios;
    }

    public void setVeterinarios(ArrayList<Veterinario> veterinarios) {
        this.veterinarios = veterinarios;
    }

    @Override
    public boolean proceder() {
        boolean seguirCorriendo = true;
        boolean cerrar = false;
        while (!cerrar) {
            int op;
            do {
                op = EntradaSalida.leerInt(
                        "ADMINISTRACIÓN - VETERINARIA THE EVIL PET\n\n"
                        + "[0] SALIR del Sistema\n"
                        + "[1] Cerrar Sesión\n"
                        + "[2] Alta producto\n"
                        + "[3] Alta usuario\n");
            } while (op < 0 || op > 3);
            switch (op) {
                case 0:
                    seguirCorriendo = false;
                    cerrar = true;
                    break;
                case 1:
                    cerrar = true;
                    EntradaSalida.mostrarString("Hasta pronto!");
                    break;
                case 2:
                    altaProducto();
                    break;
                case 3:
                    altaUsuario();
                    break;
            }
        }
        return seguirCorriendo;
    }

    public void altaProducto() {
        String desc, cat;
        double pre;
        char op;
        do {
            desc = EntradaSalida.leerString("PRODUCTO\nDescripcion del Producto: ");
            cat = EntradaSalida.leerString("PRODUCTO\nRegulares         (R)\nMedicamentos  (M)");
            pre = Double.parseDouble(EntradaSalida.leerString("PRODUCTO\nPrecio del producto: "));
            Producto p = new Producto(desc, pre, cat);
            sp.agregarProducto(p);
            EntradaSalida.mostrarString("Producto agregado correctamente al stock");
            op = EntradaSalida.leerChar("Desea agregar mas productos al stock (S/N)");
        } while (op == 's' || op == 's');
    }

    public void altaUsuario() {
        String nom, pass;
        int cat, espe, dia;
        ArrayList<Integer> dias = new ArrayList<>();
        boolean cerrar = false;
        while (!cerrar) {
            do {
                cat = EntradaSalida.leerInt(
                        "ALTA EMPLEADO\n\n"
                        + "[1] Recepcionista\n"
                        + "[2] Veterinario\n"
                        + "[3] SALIR");
            } while (cat < 1 || cat > 3);
            switch (cat) {
                case 1:
                    nom = EntradaSalida.leerString("RECEPCIONISTA\nIngrese nombre");
                    pass = EntradaSalida.leerString("RECEPCIONISTA\nIngrese su contraseña");
                    Recepcionista r = new Recepcionista(nom, pass);
                    r.setSp(sp);
                    r.setVeterinarios(veterinarios);
                    getPersonas().add(r);
                    EntradaSalida.mostrarString("Usuario agregado correctamente");
                    break;
                case 2:
                    nom = EntradaSalida.leerString("VETERINARIO\nIngrese nombre");
                    pass = EntradaSalida.leerString("VETERINARIO\nIngrese su contraseña");
                    espe = EntradaSalida.leerInt("VETERINARIO\nEspecialidad\n[1] Gato\n[2] Perro\n[3] Tortuga/Canario)");
                    for (int i = 0; i < 3; i++) {
                        dia = EntradaSalida.leerInt("Seleccionar 3 dias laborables\n\n1 Lunes\n2 Martes\n3 Miercoles\n4 Jueves\n5 Viernes\n6 Sabado");
                        dias.add(dia);
                    }
                    Veterinario v = new Veterinario(nom, pass, espe, dias);
                    v.setSp(sp);
                    getPersonas().add(v);
                    veterinarios.add(v);
                    EntradaSalida.mostrarString("Usuario agregado correctamente");
                    break;
                case 3:
                    cerrar = true;
                    break;
            }
        }
    }

}
