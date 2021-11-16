package veterinaria;

import java.io.IOException;

public class Veterinaria {

    public static void main(String[] args) throws IOException {
        Sistema s = new Sistema();
        try {
            s = s.deSerializar("veterinaria.txt");
            EntradaSalida.mostrarString("BIENVENDO A VETERINARIA THE EVIL PET");
        } catch (IOException | ClassNotFoundException e) {
            EntradaSalida.mostrarString("CARGANDO SISTEMA 1ra VEZ");
            String usuario = EntradaSalida.leerString("Registre su usuario, Administrador");
            String password = EntradaSalida.leerPassword("Registre su contraseña, Administrador");

            Administrador a = new Administrador(usuario, password);
            s.agregarPersona(a);
            a.setPersonas(s.getPersonas());
            EntradaSalida.mostrarString("Usted es el nuevo administrador, por favor logearse");
        }
        s.iniciar();
        s.serializar("veterinaria.txt");
    }
}
