package dominio;
import java.io.Serializable;

public class Producto implements Serializable {
    private String nombre;
    private float precio;
    private String cat;

    public Producto(String nombre, float precio, String cat) {
        this.nombre = nombre;
        this.precio = precio;
        this.cat = cat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return cat;
    }

    public void setCategoria(String cat) {
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Producto: " + nombre + ", Precio: " + precio + ", Categoría: " + cat;
    }
}
