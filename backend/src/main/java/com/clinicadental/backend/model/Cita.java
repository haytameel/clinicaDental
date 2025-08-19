package com.clinicadental.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "cita")
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String paciente;
    private String personal;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fecha;
    private Time hora;


    @Enumerated(EnumType.STRING)
    private TipoCita tipo;

    private String estado;
    private String notas;

    public Cita(int id, String paciente, String personal, Date fecha, Time hora, String estado, String notas, TipoCita tipo) {
        this.id = id;
        this.paciente = paciente;
        this.personal = personal;
        this.fecha = fecha;
        this.hora = hora;
        this.estado = estado;
        this.notas = notas;
        this.tipo = tipo;
    }

    public Cita() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String dentista) {
        this.personal = dentista;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoCita getTipo() {
        return tipo;
    }

    public void setTipo(TipoCita tipo) {
        this.tipo = tipo;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Time getHoraFin() {
        if (hora == null || tipo == null) return null;
        long millisInicio = hora.getTime();
        long millisFin = millisInicio + tipo.getDuracionMinutos() * 60 * 1000L;
        return new Time(millisFin);
    }


    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", paciente='" + paciente + '\'' +
                ", dentista='" + personal + '\'' +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", estado='" + estado + '\'' +
                ", notas='" + notas + '\'' +
                '}';
    }
}
