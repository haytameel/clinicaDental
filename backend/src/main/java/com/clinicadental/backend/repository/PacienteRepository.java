package com.clinicadental.backend.repository;

import com.clinicadental.backend.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Paciente findByEmail(String email);
    Paciente findByUsername(String username);
    @Query("SELECT p.nombre FROM Paciente p WHERE p.activo = true")
    List<String> buscarNombresPacientesActivos();
}