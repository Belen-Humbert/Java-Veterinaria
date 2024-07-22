package petshop;
import dominio.Producto;
import dominio.Cliente;
import dominio.Factura;
import java.util.ArrayList;
import java.util.Iterator;
public class Modelo {
 
    public static void cargarProductos() {
        ArrayList<Producto> productos = getItemProductos("archivo_producto.txt");
        if (productos != null) {
            arrayProductos = productos;
        }
    }

    public static void cargarClientes() {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) LocalStorage.getItem("archivo_cliente.txt");
        if (clientes != null) {
            arrayClientes = clientes;
        }
    }
    
    public static void cargarFacturas() {
        ArrayList<Factura> facturas = (ArrayList<Factura>) LocalStorage.getItem("archivo_factura.txt");
        if (facturas != null) {
            arrayFactura = facturas;
        }
    }
    
    private static ArrayList<Producto> arrayProductos = new ArrayList<>();
    private static ArrayList<Cliente> arrayClientes = new ArrayList<>();
    private static ArrayList<Factura> arrayFactura = new ArrayList<>();
    
    public static ArrayList<Producto> getItemProductos(String nomArchivo) {
        return (ArrayList<Producto>) LocalStorage.getItem(nomArchivo);
    }

    public static void agregarProducto(Producto producto) {
        arrayProductos.add(producto);
        guardarArrayProductos(arrayProductos);
    }

    public static ArrayList<Producto> buscarArrayProd() {
        return arrayProductos;
    }

    public static void eliminarProducto(Producto producto) {
        Iterator<Producto> iterador = arrayProductos.iterator();
        while (iterador.hasNext()) {
            Producto productoo = iterador.next();
            if (productoo.getNombre().equals(producto.getNombre())) {
                iterador.remove(); // Elimina el objeto si coincide con el nombre
            }
        }
        guardarArrayProductos(arrayProductos);
    }
   
    public static void modificarProducto(Producto productoModificado) {
        for (int i = 0; i < arrayProductos.size(); i++) {
            Producto producto = arrayProductos.get(i);
            if (producto.getNombre().equals(productoModificado.getNombre())) {
                producto.setNombre(productoModificado.getNombre());
                producto.setPrecio(productoModificado.getPrecio());
                producto.setCategoria(productoModificado.getCategoria());
                break;
            }
        }
        guardarArrayProductos(arrayProductos);
    }
    
    public static Cliente getItemCliente(String nomArchivo) {
        return (Cliente) LocalStorage.getItem(nomArchivo);
    }

    public static void agregarCliente(Cliente cliente) {
        arrayClientes.clear();
        arrayClientes.add(cliente);
        guardarArrayClientes(arrayClientes);
    }

    public static ArrayList<Cliente> buscarArrayClien() {
        return arrayClientes;
    }
    
    public static void eliminarCliente(Cliente cliente) {
        Iterator<Cliente> iterador = arrayClientes.iterator();
        while (iterador.hasNext()) {
            Cliente clientee = iterador.next();
            if (clientee.getNombreCliente().equals(cliente.getNombreCliente())) {
                iterador.remove(); // Elimina el objeto si coincide con el nombre
            }
        }
        guardarArrayClientes(arrayClientes);
    }
   
    public static void modificarCliente(Cliente clienteModificado) {
        for (int i = 0; i < arrayClientes.size(); i++) {
            Cliente cliente = arrayClientes.get(i);
            if (cliente.getIdCliente() == clienteModificado.getIdCliente()) {
                cliente.setNombreCliente(clienteModificado.getNombreCliente());
                cliente.setIdCliente(clienteModificado.getIdCliente());
                cliente.setTelefonoCliente(clienteModificado.getTelefonoCliente());
                cliente.setDireccionCliente(clienteModificado.getDireccionCliente());
                break;
            }
        }
        guardarArrayClientes(arrayClientes);
    }
    
    public static void agregarFactura(Factura factura) {
        arrayFactura.clear();
        arrayFactura.add(factura);
        guardarArrayFacturas(arrayFactura);
    }
    
    public static ArrayList<Factura> buscarArrayFacturas() {
    return arrayFactura;
}
    
    public static void guardarArrayProductos(ArrayList<Producto> arrayProductos) {
        if (arrayProductos != null) {
            LocalStorage.setItem("archivo_producto.txt", arrayProductos);
        } else {
            ArrayList<Producto> book = new ArrayList<Producto>();
            LocalStorage.setItem("archivo_producto.txt", book);
        }
    }

    public static void guardarArrayClientes(ArrayList<Cliente> arrayClientes) {
        if (arrayClientes != null) {
            LocalStorage.setItem("archivo_cliente.txt", arrayClientes);
        } else {
            ArrayList<Cliente> book = new ArrayList<Cliente>();
            LocalStorage.setItem("archivo_cliente.txt", book);
        }
    }

    public static void guardarArrayFacturas(ArrayList<Factura> arrayFactura) {
        if (arrayFactura != null) {
            LocalStorage.setItem("archivo_factura.txt", arrayFactura);
        } else {
            ArrayList<Factura> book = new ArrayList<Factura>();
            LocalStorage.setItem("archivo_factura.txt", book);
        }
    }

}