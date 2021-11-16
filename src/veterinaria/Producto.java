package veterinaria;

import java.io.Serializable;

public class Producto implements Serializable {

    String descripcion;
    double precio;
    String categoria;

    public Producto(String descripcion, double precio, String categoria) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto: " + descripcion + ", precio: " + precio + ", categoria: " + categoria;
    }

}
