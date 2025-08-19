package com.clinicadental.backend.service;

import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitaService{

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> getCitasPorPaciente(String paciente) {
        return citaRepository.findCitasByPaciente(paciente);
    }

}