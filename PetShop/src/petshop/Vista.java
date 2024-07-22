package petshop;
import dominio.Producto;
import dominio.Cliente;
import dominio.Factura;
import java.util.ArrayList;
import java.util.Scanner;

public class Vista {

    public static int menuPrincipal() {
        Scanner lector = new Scanner(System.in);
        System.out.println("");
        System.out.println("Bienvenido a Pulguitas PetShop");
        System.out.println("Seleccione 1 para gestionar productos");
        System.out.println("Seleccione 2 para gestionar clientes");
        System.out.println("Seleccione 3 para realizar una venta");
        System.out.println("Seleccione 4 mostrar las facturas");
        int resp = lector.nextInt();

        return resp;
    }

    public static int menuProducto() {
        Scanner datos = new Scanner(System.in);
        System.out.println("\nSeleccionaste Menú Producto");
        System.out.println("1-Añadir producto");
        System.out.println("2-Mostrar productos");
        System.out.println("3-Modificar producto");
        System.out.println("4-Eliminar producto");
        System.out.println("0-Volver al menu anterior");
        int opt = datos.nextInt();
        return opt;
    }

    public static Producto menuNuevoProducto() {
        Scanner datos = new Scanner(System.in);
        System.out.println("Seleccionaste agregar un nuevo producto");
        System.out.println("Ingrese el nombre");
        String nom = datos.nextLine();
        System.out.println("Ingrese el precio");
        float preci = datos.nextFloat();
        System.out.println("Ingrese la categoría");
        String catt = datos.next();

        // Devuelve el objeto Producto creado
        Producto producto = new Producto(nom, preci, catt);
        return producto;
    }

    public static void mostrarListaProducto(ArrayList<Producto> listaProductos) {
                if (listaProductos.isEmpty()) {
            System.out.println("La lista de productos está vacía.");
        } else {
            System.out.println("\nSeleccionaste mostrar productos");
            System.out.println("Lista de productos:");
        for (Producto producto : listaProductos) {
            System.out.println(producto);
        }
        }
    }

    public static Producto modificarProducto(ArrayList<Producto> listaProductos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Seleccionaste Modificar producto");
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = lector.nextLine();

        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                System.out.println("Producto encontrado. Ingrese los nuevos datos:");

                System.out.print("Nuevo nombre: ");
                String nuevoNombre = lector.nextLine();

                System.out.print("Nuevo precio: ");
                float nuevoPrecio = lector.nextFloat();

                System.out.print("Nueva categoría: ");
                String nuevaCategoria = lector.next();

                producto.setNombre(nuevoNombre);
                producto.setPrecio(nuevoPrecio);
                producto.setCategoria(nuevaCategoria);

                System.out.println("Producto modificado exitosamente.");
                return producto;
            }
        }

        System.out.println("Producto no encontrado. No se pudo modificar.");
        return null;
    }

    public static Producto eliminarProducto(ArrayList<Producto> listaProductos) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Seleccionaste Eliminar producto");
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombre = lector.nextLine();

        for (Producto producto : listaProductos) {
            System.out.println("producto.nombre "+producto.getNombre()+" - "+nombre);
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        System.out.println("Producto no encontrado. No se pudo eliminar.");
        return null;
    }

    public static int menuCliente() {
        Scanner dat = new Scanner(System.in);
        System.out.println("\nSeleccionaste Menú Cliente");
        System.out.println("Menú de opciones:");
        System.out.println("1-Agregar un cliente");
        System.out.println("2-Eliminar un cliente");
        System.out.println("3-Modificar un cliente");
        System.out.println("4-Mostrar clientes");
        System.out.println("0-Volver al menu anterior");

        int resp = dat.nextInt();
        return resp;
    }

    public static Cliente agregarNuevoCliente() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Seleccionaste agregar un nuevo cliente");

    // Manejar la excepción InputMismatchException al leer el ID del cliente
    int id = 0;
    boolean idValido = false;

    while (!idValido) {
        try {
            System.out.print("Ingrese el ID del cliente: ");
            id = scanner.nextInt();
            idValido = true;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Ingrese un ID válido (número entero).");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    // Manejar la excepción InputMismatchException al leer el teléfono del cliente
    int telefono = 0;
    boolean telefonoValido = false;

    while (!telefonoValido) {
        try {
            System.out.print("Ingrese el teléfono del cliente: ");
            telefono = scanner.nextInt();
            telefonoValido = true;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Ingrese un número de teléfono válido.");
            scanner.nextLine(); // Limpiar el buffer del scanner
        }
    }

    scanner.nextLine(); // Limpiar el buffer del scanner antes de leer la siguiente línea

    System.out.print("Ingrese el nombre del cliente: ");
    String nombre = scanner.nextLine();

    System.out.print("Ingrese la dirección del cliente: ");
    String direccion = scanner.nextLine();

    // Devuelve el objeto Cliente creado
    Cliente cliente = new Cliente(nombre, id, telefono, direccion);
    return cliente;
}

    
    public static Cliente eliminarCliente(ArrayList<Cliente> listaClientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccionaste eliminar un cliente");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int id = scanner.nextInt();

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            if (cliente.getIdCliente() == id) {
                listaClientes.remove(i);
                return cliente;
            }
        }
        System.out.println("Cliente no encontrado. No se pudo eliminar.");
        return null;
    }
    
    public static Cliente modificarCliente(ArrayList<Cliente> listaClientes) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Seleccionaste modificar un cliente");
    System.out.print("Ingrese el ID del cliente a modificar: ");
    int id = scanner.nextInt();

    for (int i = 0; i < listaClientes.size(); i++) {
        Cliente cliente = listaClientes.get(i);
        if (cliente.getIdCliente() == id) {
            scanner.nextLine(); // Consumir el salto de línea
            System.out.print("Ingrese el nuevo nombre del cliente: ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese el nuevo teléfono del cliente: ");
            int nuevoTelefono = scanner.nextInt();

            scanner.nextLine(); // Consumir el salto de línea

            System.out.print("Ingrese la nueva dirección del cliente: ");
            String nuevaDireccion = scanner.nextLine();

            // Crear un nuevo objeto Cliente con los valores modificados
            Cliente clienteModificado = new Cliente(nuevoNombre, id, nuevoTelefono, nuevaDireccion);

            System.out.println("Cliente modificado exitosamente.");
            return clienteModificado;
        }
    }
    
    System.out.println("Cliente no encontrado. No se pudo modificar.");
    return null;
}

    public static void mostrarListaClientes(ArrayList<Cliente> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("La lista de clientes está vacía.");
        } else {
            System.out.println("Seleccionaste mostrar clientes");
            System.out.println("Lista de clientes:");
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                System.out.println(cliente);
}
            }
        }
    
    public static int menuVenta(){
         Scanner dat = new Scanner(System.in);
        System.out.println("\nSeleccionaste Menú ventas");
        System.out.println("Menú de venta:");
        System.out.println("1-Generar Venta");
        System.out.println("2-Mostrar Ventas");
        System.out.println("0-Salir");
        int resp = dat.nextInt();
        return resp;
    }
    
    public static Factura venderProducto(ArrayList<Producto> listaProductos, ArrayList<Cliente> listaClientes) {
        Scanner lector = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto que desea comprar: ");
        String nombreProducto = lector.nextLine();

        System.out.print("Ingrese el ID del cliente que realiza la compra: ");
        int idCliente = lector.nextInt();

        System.out.print("Ingrese la cantidad de productos vendidos: ");
        int cantidad = lector.nextInt();

        Producto productoVendido = null;
        Cliente clienteComprador = null;

        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombreProducto)) {
                productoVendido = producto;
                break;
            }
        }

        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == idCliente) {
                clienteComprador = cliente;
                break;
            }
        }

        if (productoVendido != null && clienteComprador != null) {
            Factura factura = new Factura(productoVendido, clienteComprador, cantidad);
            return factura;
        } else {
            System.out.println("Producto o cliente no encontrado. No se pudo completar la venta.");
            return null;
        }
    }
    
    public static void mostrarFacturas(ArrayList<Factura> facturas) {
    if (facturas.isEmpty()) {
        System.out.println("No hay facturas disponibles.");
    } else {
        System.out.println("Lista de Facturas:");
        for (Factura factura : facturas) {
            System.out.println(factura);
        }
    }
}
}
//isEmpty se usa para verificar si la coleccion de facturas esta vacía o no