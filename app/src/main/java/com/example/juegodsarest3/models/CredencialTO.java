package com.example.juegodsarest3.models;

public class CredencialTO {
    private String correo;
    private String password;

    public CredencialTO(){}

    public CredencialTO(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}