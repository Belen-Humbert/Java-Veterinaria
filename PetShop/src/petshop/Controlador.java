package petshop;

import dominio.Producto;
import dominio.Cliente;
import dominio.Factura;
import java.util.ArrayList;

public class Controlador {
    public static void main(String[] args) {
        Modelo.cargarProductos(); // Cargar productos, facturas y clientes al inicio
        Modelo.cargarClientes();
        Modelo.cargarFacturas();
        int opt = 0;
        Factura factura = null;
        
        while (opt != 4) {
            // Menú principal
            opt = Vista.menuPrincipal();

            if (opt == 1) {
                // Menú de productos
                int resp = 0;
                while (resp != 5) {
                  
                    resp = Vista.menuProducto();

                    if (resp == 1) {
                        Producto producto = Vista.menuNuevoProducto();
                        Modelo.agregarProducto(producto);
                    } else if (resp == 2) {
                        ArrayList<Producto> busqueda = Modelo.buscarArrayProd();
                        Vista.mostrarListaProducto(busqueda);
                    } else if (resp == 3) {
                        ArrayList<Producto> busqueda = Modelo.buscarArrayProd();
                        Producto productoModificado = Vista.modificarProducto(busqueda);
                        if (productoModificado != null) {                       
                            System.out.println("Producto modificado: " + productoModificado);
                            Modelo.modificarProducto(productoModificado);
                        }
                    } else if (resp == 4) {
                        ArrayList<Producto> busqueda = Modelo.buscarArrayProd();
                        Producto productoEliminado = Vista.eliminarProducto(busqueda);
                        if (productoEliminado != null) {
                            System.out.println("Producto eliminado.");
                            Modelo.eliminarProducto(productoEliminado);
                        }
                    } else if (resp == 0) {
                        break;  // vuelve al menú principal
                    }
                }
            } else if (opt == 2) {
                // Menú de clientes
                int resp = 0;
                while (resp != 5) {
                    resp = Vista.menuCliente();

                    if (resp == 1) {
                        Cliente cliente = Vista.agregarNuevoCliente();
                        Modelo.agregarCliente(cliente);
                    } else if (resp == 2) {
                        ArrayList<Cliente> busqueda = Modelo.buscarArrayClien();
                        Cliente clienteEliminado = Vista.eliminarCliente(busqueda);
                        if (clienteEliminado != null) {
                            System.out.println("Cliente eliminado: " + clienteEliminado);
                            Modelo.eliminarCliente(clienteEliminado);
                        }
                    } else if (resp == 3) {
                        ArrayList<Cliente> busqueda = Modelo.buscarArrayClien();
                        Cliente clienteModificado = Vista.modificarCliente(busqueda);
                        if (clienteModificado != null ) {
                            System.out.println("Cliente modificado: " + clienteModificado);
                            Modelo.modificarCliente(clienteModificado);
                        }
                    } else if (resp == 4) {
                        
                        ArrayList<Cliente> busquedaa = Modelo.buscarArrayClien();
                        Vista.mostrarListaClientes(busquedaa);
                    } else if (resp == 0) {
                        break;  // vuelve al menú principal
                    }
                }
            } else if (opt == 3) {
                ArrayList<Producto> busqueda = Modelo.buscarArrayProd();
                ArrayList<Cliente> busquedaa = Modelo.buscarArrayClien();
                Vista.mostrarListaProducto(busqueda);
                Vista.mostrarListaClientes(busquedaa);

                factura = Vista.venderProducto(busqueda, busquedaa);
                if (factura != null) {
                    Modelo.agregarFactura(factura);
                }
            } else if (opt == 4) {
                ArrayList<Factura> facturas = Modelo.buscarArrayFacturas();
                Vista.mostrarFacturas(facturas);
            }
        }
    }
}
