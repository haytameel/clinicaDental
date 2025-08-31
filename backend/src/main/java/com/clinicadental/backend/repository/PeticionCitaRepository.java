package com.clinicadental.backend.repository;

import com.clinicadental.backend.model.EstadoCita;
import com.clinicadental.backend.model.PeticionCita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface PeticionCitaRepository extends JpaRepository<PeticionCita, Integer> {

    List<PeticionCita> findAllByUsername(String username);

    List<PeticionCita> findAllByFechaAfter(Date fecha);

    List<PeticionCita> findAllByFechaBefore(Date fecha);
    List<PeticionCita> findAllByOrderByFechaAscHoraAsc();
    List<PeticionCita> findAllByEstado(EstadoCita estado);


}
