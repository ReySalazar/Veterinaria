package veterinaria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Sistema implements Serializable {

    private Administrador a;
    private ArrayList<Persona> personas;

    public Sistema() {
        personas = new ArrayList();
    }

    public Sistema deSerializar(String a) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(a);
        ObjectInputStream o = new ObjectInputStream(f);
        Sistema s = (Sistema) o.readObject();
        o.close();
        f.close();
        return s;
    }

    public void serializar(String a) throws IOException {
        FileOutputStream f = new FileOutputStream(a);
        ObjectOutputStream o = new ObjectOutputStream(f);
        o.writeObject(this);
        o.close();
        f.close();
    }

    public Persona buscarPersona(String datos) {
        int i = 0;
        boolean encontrado = false;
        Persona p = null;

        while (i < personas.size() && !encontrado) {
            p = personas.get(i);
            if (datos.equals(p.getUsuario() + ":" + p.getPassword())) {
                encontrado = true;
            } else {
                i++;
            }
        }
        if (!encontrado) {
            return null;
        } else {
            return p;
        }
    }

    public void agregarPersona(Persona p) {
        if (p != null) {
            personas.add(p);
        }
    }

    public Administrador getA() {
        return a;
    }

    public void setA(Administrador a) {
        this.a = a;
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    void iniciar() {
        boolean corriendo = true;
        while (corriendo) {
            Persona u = null;
            do {
                String usuario = EntradaSalida.leerString("Ingrese su usuario");
                String password = EntradaSalida.leerPassword("Ingrese su contraseña");
                for (Persona p : personas) {
                    if (p.getUsuario().equalsIgnoreCase(usuario) && p.getPassword().equals(password)) {
                        u = p;
                        break;
                    }
                }
                if (u == null) {
                    EntradaSalida.mostrarString("Usuario/Contraseña incorrecto o inexistente");
                }

            } while (u == null);
            corriendo = u.proceder();
        }
        EntradaSalida.mostrarString("Hasta mañana!");
    }
}
