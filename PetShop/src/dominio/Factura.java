package dominio;
import java.io.Serializable;
import java.util.Random;

public class Factura implements Serializable{

    private int codigoFactura;
    private Producto productoVendido;
    private Cliente clienteComprador;
    private int cantidad;

    public Factura(Producto productoVendido, Cliente clienteComprador, int cantidad) {
        this.productoVendido = productoVendido;
        this.clienteComprador = clienteComprador;
        this.cantidad = cantidad;
        this.codigoFactura = generarCodigoFactura();
    }

    @Override
    public String toString() {
        return "Factura{" +
               "codigoFactura=" + codigoFactura +
               ", productoVendido=" + productoVendido +
               ", clienteComprador=" + clienteComprador +
               ", cantidad=" + cantidad +
               '}';
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    public Producto getProductoVendido() {
        return productoVendido;
    }

    public Cliente getClienteComprador() {
        return clienteComprador;
    }

    public int getCantidad() {
        return cantidad;
    }

    private int generarCodigoFactura() {
        // Generar un código de factura único, por ejemplo, utilizando números aleatorios
        return new Random().nextInt(10000); // Puedes personalizar esto según tus necesidades.
    }
}
