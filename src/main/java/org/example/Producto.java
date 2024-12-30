package org.example;

import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    String ID;
    String nombre;
    String categoria;
    String Descripcion;
    double precio;
    int stock;
    double peso;
    String Proveedor;
    String fechaIngreso;
    double descuento;

    public Producto(String ID, String nombre, String categoria, String descripcion, double precio, int stock, double peso, String proveedor, String fechaIngreso, double descuento) {
        this.ID = ID;
        this.nombre = nombre;
        this.categoria = categoria;
        Descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.peso = peso;
        Proveedor = proveedor;
        this.fechaIngreso = fechaIngreso;
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ID='" + ID + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", Descripcion='" + Descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", peso=" + peso +
                ", Proveedor='" + Proveedor + '\'' +
                ", fechaIngreso='" + fechaIngreso + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
