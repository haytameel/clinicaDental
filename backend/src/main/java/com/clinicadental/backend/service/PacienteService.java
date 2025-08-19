package com.clinicadental.backend.service;

import com.clinicadental.backend.model.Paciente;

import java.util.List;
import java.util.Optional;


public interface PacienteService {
    List<Paciente> getAllPacientes();
    Paciente getPacienteById(String id);
    Paciente savePaciente(Paciente paciente);
    void deletePaciente(String id);

   // List<String> buscarNombresPacientesActivos();

}