package com.example.juegodsarest3.models;

public class Usuario {
    private String correo;
    private String password;
    private String name;

    public Usuario(){}

    public Usuario(String correo, String password, String name) {
        this.correo = correo;
        this.password = password;
        this.name = name;

    }

    public String getCorreo() {
        return correo;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


}