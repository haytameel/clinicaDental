package com.clinicadental.backend.controller;


import com.clinicadental.backend.model.Paciente;
import com.clinicadental.backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paciente")
@CrossOrigin(origins = "*") // importante, para permitir llamadas desde frontend
//@PreAuthorize("hasRole('ADMIN') or hasRole('PERSONAL')") esto por ejemplo limita que solo puedan acceder
//usuarios con rol admin o personal
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listarTodos() {
        Paciente paciente = new Paciente();
        paciente.setNombre("PEPEEE");
        return List.of(paciente);
    }

    @GetMapping("/{id}")
    public Paciente obtenerPorId(@PathVariable Long id) {
        return pacienteService.getPacienteById(id);
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable Long id, @RequestBody Paciente paciente) {
        Paciente pacienteExistente = pacienteService.getPacienteById(id);
        if (pacienteExistente != null) {
            pacienteExistente.setNombre(paciente.getNombre());
            pacienteExistente.setApellidos(paciente.getApellidos());
            pacienteExistente.setEmail(paciente.getEmail());
            pacienteExistente.setDireccion(paciente.getDireccion());
            pacienteExistente.setGenero(paciente.getGenero());
            pacienteExistente.setEnfermedades(paciente.getEnfermedades());
            pacienteExistente.setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteExistente.setApellidos(paciente.getApellidos());
            pacienteExistente.setNumTelefono(paciente.getNumTelefono());
            return pacienteService.savePaciente(pacienteExistente);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pacienteService.deletePaciente(id);
    }
}