package veterinaria;

import java.io.Serializable;
import java.util.ArrayList;

public class StockProductos implements Serializable {

    ArrayList<Producto> productos;

    public StockProductos() {
        productos = new ArrayList();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public void agregarProducto(Producto p) {
        if (p != null) {
            productos.add(p);
        }
    }

    public String mostrarProductos() {
        String lista = "";
        for (int i = 0; i < productos.size(); i++) {
            lista += "[" + (i + 1) + "] " + productos.get(i) + "\n";
        }
        return lista;
    }

}
