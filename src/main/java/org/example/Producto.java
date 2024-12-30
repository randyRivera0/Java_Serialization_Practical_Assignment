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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String proveedor) {
        Proveedor = proveedor;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
