package org.example.ProductosP;

public class Productos {
    private int id;
    private String Nombre;
    private double Precio;

    public Productos() {
    }

    public Productos(int id, String nombre, double precio) {
        this.id = id;
        Nombre = nombre;
        Precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Precio=" + Precio +
                '}';
    }
}
