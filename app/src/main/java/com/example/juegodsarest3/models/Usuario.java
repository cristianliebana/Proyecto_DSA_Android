package com.example.juegodsarest3.models;

public class Usuario {
    private String correo;
    private String password;
    private String nombre;

    public Usuario(){}

    public Usuario(String correo, String password, String nombre) {
        this.correo = correo;
        this.password = password;
        this.nombre = nombre;

    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }


}