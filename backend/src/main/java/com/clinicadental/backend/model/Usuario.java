package com.clinicadental.backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Rol rol;

    public Usuario(String username, String password, Rol rol) {
        this.username = username;
        this.password = password;
        this.rol=rol;
    }

    public Usuario() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }
}
