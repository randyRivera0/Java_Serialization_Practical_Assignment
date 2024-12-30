package org.example;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de gestionar la lectura de un archivo de texto y la serialización de objetos Producto.
 *
 * @author Nombre Apellido
 * @version POO - 2024-2025 CII
 * @since 29-12-2024, 12:00 horas
 */
public class GestorArchivoTxt {

     /**
     * Método para leer un archivo .txt y convertir sus filas en una lista de objetos Producto.
     *
     * @param rutaArchivo Ruta del archivo .txt a leer.
     * @return Lista de objetos Producto leída del archivo.
     * @throws ArchivoNoEncontradoException Si el archivo no existe.
     * @throws FormatoNoValidoException Si el formato de una fila no es válido.
     */
    public List<Producto> leerArchivo(String rutaArchivo) throws ArchivoNoEncontradoException, FormatoNoValidoException {
        List<Producto> productos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            int lineaActual = 0;

            while ((linea = br.readLine()) != null) {
                lineaActual++;

                // Saltar la primera línea (cabecera)
                if (lineaActual == 1) continue;

                try {
                    String[] datos = linea.split(",");

                    // Validar que la fila tenga exactamente 10 columnas
                    if (datos.length != 10) {
                        throw new FormatoNoValidoException("Error en la fila " + lineaActual + ": formato incorrecto.");
                    }

                    // Crear un objeto Producto y agregarlo a la lista
                    Producto producto = new Producto(datos[0], datos[1], datos[2], datos[3], Double.parseDouble(datos[4]), Integer.parseInt(datos[5]), Double.parseDouble(datos[6]), datos[7], datos[8], Double.parseDouble(datos[9]));
                    productos.add(producto);

                } catch (NumberFormatException e) {
                    throw new FormatoNoValidoException("Error en la fila " + lineaActual + ": formato numérico inválido.");
                }
            }
        } catch (FileNotFoundException e) {
            throw new ArchivoNoEncontradoException("Archivo no encontrado: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productos;
    }
}


