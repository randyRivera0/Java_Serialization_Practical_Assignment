package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar productos en un inventario.
 * Proporciona métodos para agregar, buscar, listar y actualizar productos.
 *
 * @author Nombre Apellido
 * @version POO - 2024-2025 CII
 * @since 29-12-2024, 14:00 horas
 */
public class Inventario {
    private List<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList<>();
    }

    public Inventario(List<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Agrega un nuevo producto o actualiza la cantidad de un producto existente.
     *
     * @param nuevoProducto Producto a agregar o actualizar.
     * @throws ErrorEscrituraArchivoException Si ocurre un error al escribir en el archivo.
     */
    public void agregarProducto(Producto nuevoProducto) throws ErrorEscrituraArchivoException {
        try {
            boolean productoExistente = false;

            for (Producto producto : productos) {
                if (producto.ID.equals(nuevoProducto.ID)) {
                    producto.stock += nuevoProducto.stock; // Actualiza la cantidad
                    productoExistente = true;
                    break;
                }
            }

            if (!productoExistente) {
                productos.add(nuevoProducto); // Agrega el nuevo producto
            }
        } catch (Exception e) {
            throw new ErrorEscrituraArchivoException("Error al agregar o actualizar el producto.");
        }
    }

    /**
     * Busca un producto por su ID.
     *
     * @param id ID del producto a buscar.
     * @return Producto encontrado.
     * @throws ProductoNoEncontradoException Si el producto no existe.
     */
    public Producto buscarProducto(String id) throws ProductoNoEncontradoException {
        for (Producto producto : productos) {
            if (producto.ID.equals(id)) {
                return producto;
            }
        }
        throw new ProductoNoEncontradoException("Producto con ID " + id + " no encontrado.");
    }

    /**
     * Lista todos los productos en el inventario.
     *
     * @return Lista de productos existentes.
     */
    public List<Producto> listarProductos() {
        return new ArrayList<>(productos);
    }

    /**
     * Actualiza la cantidad de un producto en el inventario restando la cantidad especificada.
     *
     * @param id ID del producto a actualizar.
     * @param cantidad Cantidad a restar.
     * @throws ProductoNoEncontradoException Si el producto no existe.
     * @throws CantidadInsuficienteException Si la cantidad a reducir es mayor al stock disponible.
     */
    public void actualizarCantidad(String id, int cantidad) throws ProductoNoEncontradoException, CantidadInsuficienteException {
        Producto producto = buscarProducto(id);

        if (producto.stock < cantidad) {
            throw new CantidadInsuficienteException("Cantidad insuficiente en inventario para el producto con ID " + id);
        }

        producto.stock -= cantidad;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }
}

