package com.clinicadental.backend.repository;

import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface CitaRepository extends JpaRepository<Cita, Long> {
    Optional<Cita> findById(Long citaId);

    List<Cita> findCitasByPaciente(String paciente);

    List<Cita> findCitasByPacienteOrderByFechaDesc(String paciente);

    List<Cita> findCitasByPacienteOrderByFechaAsc(String paciente);


    @Query("SELECT c FROM Cita c WHERE c.paciente = :paciente AND c.fecha >= :fecha")
    List<Cita> findCitasFuturasByPaciente(String paciente, Date fecha);

    @Query("SELECT c FROM Cita c WHERE c.paciente = :paciente AND c.fecha < :fecha")
    List<Cita> findCitasPasadasByPaciente(String paciente, Date fecha);


    List<Cita> findByFechaBetween(LocalDate start, LocalDate end);


    @Query("SELECT c FROM Cita c WHERE c.paciente = :nombre")
    List<Cita> buscarPorNombrePaciente(@Param("nombre") String nombre);


}

