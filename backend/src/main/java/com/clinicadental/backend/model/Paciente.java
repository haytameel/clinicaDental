// Paciente.java
package com.clinicadental.backend.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    private String id; // DNI

    @Column(nullable = false, unique = true)
    private String username; // Relacionado con usuario

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private char genero;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String direccion;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    @Column(name = "seguro_dental")
    private Boolean seguroDental;

    @Column(name = "num_seguro")
    private String numSeguro;

    private String notas;

//    // Relación con usuario (es opcional, puedo no ponerlo)
//    @OneToOne
//    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
//    private Usuario usuario; //tabla actual, tabla referenciada

    public Paciente() {}

    public Paciente(String id, String username, String nombre, String apellidos, String email, String telefono, char genero, Date fechaNacimiento, String direccion, String codigoPostal, Boolean seguroDental, String numSeguro, String notas) {
        this.id = id;
        this.username = username;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
        this.seguroDental = seguroDental;
        this.numSeguro = numSeguro;
        this.notas = notas;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }

    public Boolean getSeguroDental() { return seguroDental; }
    public void setSeguroDental(Boolean seguroDental) { this.seguroDental = seguroDental; }

    public String getNumSeguro() { return numSeguro; }
    public void setNumSeguro(String numSeguro) { this.numSeguro = numSeguro; }

    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }

//    public Usuario getUsuario() { return usuario; }
//    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
