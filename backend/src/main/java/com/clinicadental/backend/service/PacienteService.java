package com.clinicadental.backend.service;

import com.clinicadental.backend.model.Paciente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PacienteService {
    List<Paciente> getAllPacientes();
    Paciente getPacienteById(Long id);
    Paciente savePaciente(Paciente paciente);
    void deletePaciente(Long id);

    List<String> buscarNombresPacientesActivos();

}