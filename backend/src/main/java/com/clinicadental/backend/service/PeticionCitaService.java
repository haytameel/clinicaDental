package com.clinicadental.backend.service;

import com.clinicadental.backend.dto.CitaRequest;
import com.clinicadental.backend.model.EstadoCita;
import com.clinicadental.backend.model.PeticionCita;
import com.clinicadental.backend.repository.CitaRepository;
import com.clinicadental.backend.repository.PeticionCitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class PeticionCitaService {

    @Autowired
    private PeticionCitaRepository peticionCitaRepository;

    public List<PeticionCita> getPeticionesUsuario(String username) {
        return peticionCitaRepository.findAllByUsername(username);
    }

    public List<PeticionCita> getPeticionesPosterioresA(Date fecha){
        return peticionCitaRepository.findAllByFechaAfter(fecha);
    }

    public List<PeticionCita> getPeticionesAnterioresA(Date fecha){
        return peticionCitaRepository.findAllByFechaBefore(fecha);
    }
    //el mas importante
    public List<PeticionCita> getPeticionesOrdenadas(){
        return peticionCitaRepository.findAllByOrderByFechaAscHoraAsc();
    }

    public List<PeticionCita> getPeticionesPorEstado(EstadoCita estado){
        return peticionCitaRepository.findAllByEstado(estado);
    }

    public void save(CitaRequest citaRequest){
        PeticionCita peticionCita = new PeticionCita();

        peticionCita.setUsername(citaRequest.getUsername());
        peticionCita.setEstado(citaRequest.getEstado());
        peticionCita.setFecha(citaRequest.getFecha());
        peticionCita.setHora(citaRequest.getHora());
        peticionCita.setNotas(citaRequest.getNotas());
        peticionCita.setHoraFin(citaRequest.getHoraFin());
        peticionCita.setTipo(citaRequest.getTipo());

        peticionCitaRepository.save(peticionCita);
    }

}
