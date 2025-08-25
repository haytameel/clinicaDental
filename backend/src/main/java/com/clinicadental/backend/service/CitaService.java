package com.clinicadental.backend.service;

import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class CitaService{

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> getAllCitas() {
        return citaRepository.findAll();
    }

    public List<Cita> getTodasCitasPorPaciente(String paciente) {
        return citaRepository.findCitasByPaciente(paciente);
    }

    public List<Cita> getTodasOrdenadasCitasPorPaciente(String paciente) {
        return citaRepository.findCitasByPacienteOrderByFechaDesc(paciente);
    }

    public List<Cita> getCitasFuturasPorPaciente(String paciente) {
        LocalDate hoy = LocalDate.now();
        Date fecha = java.sql.Date.valueOf(hoy); // convierte LocalDate a Date
        return citaRepository.findCitasFuturasByPaciente(paciente, fecha);
    }
    public List<Cita> getCitasPasadasPorPaciente(String paciente) {
        LocalDate hoy = LocalDate.now();
        Date fecha = java.sql.Date.valueOf(hoy);
        return citaRepository.findCitasPasadasByPaciente(paciente,fecha);
    }

    //habria que tener en cuenta que no exista una en ala misma franja horaria...
    public Cita agendarCita( Cita cita){
        return citaRepository.save(cita);
    }

}