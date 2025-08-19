package com.clinicadental.backend.service;


import com.clinicadental.backend.model.Paciente;
import com.clinicadental.backend.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public  class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public List<Paciente> getAllPacientes() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> getPacienteById(String id) {
        System.out.println("id: "+id);
        return Optional.ofNullable(pacienteRepository.findById(id).orElse(null));
    }

    @Override
    public Paciente savePaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public void deletePaciente(String id) {
        pacienteRepository.deleteById(id);
    }

//    @Override
//    public List<String> buscarNombresPacientesActivos() {
//        return pacienteRepository.buscarNombresPacientesActivos();
//    }

}