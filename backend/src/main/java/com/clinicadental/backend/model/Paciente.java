package com.clinicadental.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente {

    private String username;

    @Id
    private String id;//dni

    private String nombre;

    private String apellidos;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private char genero;

    private String email;

    private String direccion;

    private String numTelefono;

    private Date fechaRegistro;

    private String enfermedades;//enfermedaes, alergias, problemas con anestesia...

    private boolean activo;

    public Paciente() {
    }


    public Paciente(String username, String id, String nombre, String apellidos, LocalDate fechaNacimiento, char genero, String email, String direccion, String numTelefono, Date fechaRegistro, String enfermedades, boolean activo) {
        this.username = username;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.email = email;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.fechaRegistro = fechaRegistro;
        this.enfermedades = enfermedades;
        this.activo = activo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "username='" + username + '\'' +
                ", id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", genero=" + genero +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                ", enfermedades='" + enfermedades + '\'' +
                ", activo=" + activo +
                '}';
    }
}