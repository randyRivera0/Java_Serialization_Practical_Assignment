package org.example;

import java.util.Scanner;

/**
 * Clase encargada de gestionar el menú interactivo para la gestión del inventario.
 *
 * @author ...
 * @version POO - 2024-2025 CII
 * @since 29-12-2024, 14:30 horas
 */
public class MenuInteractivo {
    private final Inventario inventario;
    private final Serializadora serializadora;
    private final Scanner scanner;

    public MenuInteractivo(Inventario inventario, Serializadora serializadora, Scanner scanner) {
        this.inventario = inventario;
        this.serializadora = serializadora;
        this.scanner = scanner;
    }

    /**
     * Inicia el menú interactivo.
     */
    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1 -> agregarProducto();
                case 2 -> buscarProducto();
                case 3 -> listarProductos();
                case 4 -> actualizarCantidad();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void mostrarMenu() {
        System.out.println("\n=== Menú de Gestión de Inventario ===");
        System.out.println("1. Agregar o actualizar productos");
        System.out.println("2. Buscar producto por ID");
        System.out.println("3. Listar todos los productos");
        System.out.println("4. Actualizar cantidad de productos");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private void agregarProducto() {
        try {
            System.out.println("Ingrese los datos del producto:");
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Categoría: ");
            String categoria = scanner.nextLine();
            System.out.print("Descripción: ");
            String descripcion = scanner.nextLine();
            System.out.print("Precio: ");
            double precio = scanner.nextDouble();
            System.out.print("Stock: ");
            int stock = scanner.nextInt();
            System.out.print("Peso: ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir nueva línea
            System.out.print("Proveedor: ");
            String proveedor = scanner.nextLine();
            System.out.print("Fecha de ingreso: ");
            String fechaIngreso = scanner.nextLine();
            System.out.print("Descuento: ");
            double descuento = scanner.nextDouble();

            Producto nuevoProducto = new Producto(id, nombre, categoria, descripcion, precio, stock, peso, proveedor, fechaIngreso, descuento);
            inventario.agregarProducto(nuevoProducto);
            serializadora.serializarProductos("productos.poo", inventario.getProductos());

            System.out.println("Producto agregado o actualizado exitosamente.");
        } catch (ErrorEscrituraArchivoException e) {
            System.err.println(e.getMessage());
        }
    }

    private void buscarProducto() {
        try {
            System.out.print("Ingrese el ID del producto a buscar: ");
            String id = scanner.nextLine();
            Producto producto = inventario.buscarProducto(id);
            System.out.println("Producto encontrado: " + producto);
        } catch (ProductoNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    private void listarProductos() {
        System.out.println("\n=== Lista de Productos ===");
        for (Producto producto : inventario.listarProductos()) {
            System.out.println(producto);
        }
    }

    private void actualizarCantidad() {
        try {
            System.out.print("Ingrese el ID del producto: ");
            String id = scanner.nextLine();
            System.out.print("Ingrese la cantidad a restar: ");
            int cantidad = scanner.nextInt();

            inventario.actualizarCantidad(id, cantidad);
            serializadora.serializarProductos("productos.poo", inventario.getProductos());

            System.out.println("Cantidad actualizada exitosamente.");
        } catch (ProductoNoEncontradoException | CantidadInsuficienteException e) {
            System.err.println(e.getMessage());
        } catch (ErrorEscrituraArchivoException e) {
            System.err.println("Error al guardar los cambios: " + e.getMessage());
        }
    }
}

