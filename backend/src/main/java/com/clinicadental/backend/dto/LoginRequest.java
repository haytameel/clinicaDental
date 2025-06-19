package com.clinicadental.backend.dto;


import com.clinicadental.backend.model.Rol;

//para pasar los datos
public class LoginRequest {
    private String username;
    private String password;

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    private Rol rol;


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
}
