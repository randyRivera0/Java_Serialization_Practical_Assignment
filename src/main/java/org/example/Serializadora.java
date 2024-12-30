package org.example;

import java.io.*;
import java.util.List;

/**
 * Clase encargada de manejar la serialización y deserialización de la lista de productos.
 *
 * @author ...
 * @version ...
 */
public class Serializadora {
    /**
     * Método para serializar una lista de objetos Producto en un archivo con extensión .poo.
     *
     * @param rutaArchivo Ruta del archivo .poo donde se guardará la lista serializada.
     * @param productos Lista de objetos Producto a serializar.
     * @throws ErrorEscrituraArchivoException Si ocurre un error al escribir en el archivo.
     */
    public void serializarProductos(String rutaArchivo, List<Producto> productos) throws ErrorEscrituraArchivoException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(productos);
        } catch (IOException e) {
            throw new ErrorEscrituraArchivoException("Error al escribir en el archivo: " + rutaArchivo + "\n");
        }
    }

    /**
     * Carga el inventario desde un archivo serializado.
     *
     * @param rutaArchivo Nombre del archivo.
     * @return Inventario cargado.
     * @throws ArchivoNoEncontradoException Si el archivo no existe.
     */

    public List<Producto> deserializarProductos (String rutaArchivo) throws ArchivoNoEncontradoException{
        List<Producto> productos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            productos = (List<Producto>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException("Archivo no encontrado: " + rutaArchivo);
        } catch (IOException | ClassNotFoundException e) {
            throw new ArchivoNoEncontradoException("Error al leer el archivo: " + rutaArchivo);
        }
        return productos;
    }
}
