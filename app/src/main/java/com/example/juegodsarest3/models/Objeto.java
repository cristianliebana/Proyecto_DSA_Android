package com.example.juegodsarest3.models;

public class Objeto {

    private String nombre;
    private String descripcion;
    private double precio;

    private String fotoImagen;

    public String getFotoImagen() {
        return fotoImagen;
    }

    public void setFotoImagen(String fotoImagen) {
        this.fotoImagen = fotoImagen;
    }

    public Objeto(){}
    public Objeto(String nombre, String descripcion, double precio,String fotoImagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fotoImagen=fotoImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
