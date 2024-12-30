package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestorArchivoTxt gestor = new GestorArchivoTxt();
        Serializadora serializadora = new Serializadora();
        String rutaEntrada = "src/main/resources/productos.txt";
        String rutaSalida = "src/main/resources/productos.poo";
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        MenuInteractivo menu = new MenuInteractivo(inventario, serializadora, scanner);

        try {
            // Leer archivo .txt y crear la lista de productos
            List<Producto> productos = gestor.leerArchivo(rutaEntrada);

            // Serializar la lista de productos en el archivo .poo
            serializadora.serializarProductos(rutaSalida, productos);

            System.out.println("Archivo procesado y serializado correctamente.");
        } catch (ArchivoNoEncontradoException | FormatoNoValidoException | ErrorEscrituraArchivoException e) {
            System.err.println(e.getMessage());
        }

        // Intentar cargar productos desde el archivo serializado
        try {
            inventario.setProductos(serializadora.deserializarProductos(rutaSalida));
            System.out.println("Archivo de productos cargado exitosamente.");
        } catch (ArchivoNoEncontradoException e) {
            System.err.println(e.getMessage());
            System.out.println("Iniciando inventario vacío.");
        }

        menu.iniciar();
        scanner.close();
    }
}