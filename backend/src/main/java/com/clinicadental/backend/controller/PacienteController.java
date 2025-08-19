package com.clinicadental.backend.controller;


import com.clinicadental.backend.dto.ApiResponse;
import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.model.Paciente;
import com.clinicadental.backend.service.CitaService;
import com.clinicadental.backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@CrossOrigin(origins = "*") // importante, para permitir llamadas desde frontend
//@PreAuthorize("hasRole('ADMIN') or hasRole('PERSONAL')") esto por ejemplo limita que solo puedan acceder
//usuarios con rol admin o personal
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private CitaService citaService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Paciente>>> listarTodos(Authentication authentication) {

        String username = authentication.getName();
        String rol=authentication.getAuthorities().toString();
       // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<List<Paciente>> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE"))) {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        response=new ApiResponse<>("succes","listado de todos los pacientes",pacientes);
        return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/{id}")
    public Optional<Paciente> obtenerPorId(@PathVariable String id) {
        System.out.println("iddddd: "+id);
        System.out.println(pacienteService.getPacienteById(id));
        return pacienteService.getPacienteById(id);
    }

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return pacienteService.savePaciente(paciente);
    }

    @PutMapping("/{id}")
    public Paciente actualizar(@PathVariable String id, @RequestBody Paciente paciente) {
        Optional<Paciente> pacienteExistente = pacienteService.getPacienteById(id);
        if (pacienteExistente != null) {
            pacienteExistente.get().setId(paciente.getId());
            pacienteExistente.get().setNombre(paciente.getNombre());
            pacienteExistente.get().setApellidos(paciente.getApellidos());
            pacienteExistente.get().setEmail(paciente.getEmail());
            pacienteExistente.get().setDireccion(paciente.getDireccion());
            pacienteExistente.get().setGenero(paciente.getGenero());
            pacienteExistente.get().setNotas(paciente.getNotas());
            pacienteExistente.get().setFechaNacimiento(paciente.getFechaNacimiento());
            pacienteExistente.get().setApellidos(paciente.getApellidos());
            pacienteExistente.get().setTelefono(paciente.getTelefono());
            pacienteExistente.get().setCodigoPostal(paciente.getCodigoPostal());
            pacienteExistente.get().setSeguroDental(paciente.getSeguroDental());
            pacienteExistente.get().setNumSeguro(paciente.getNumSeguro());


            return pacienteService.savePaciente(pacienteExistente.get());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        pacienteService.deletePaciente(id);
    }



    @GetMapping("/citas")
    public List<Cita> getCitasDePacienteAutenticado(Authentication authentication) {
        String username = authentication.getName(); // el "sub" del token
        System.out.println("Usuario autenticado: " + authentication.getName());
        System.out.println("Authorities: " + authentication.getAuthorities());
        return citaService.getCitasPorPaciente(username);
    }
}

/*
@GetMapping("/api/citas")
public List<Cita> getCitasDePacienteAutenticado(Authentication authentication) {
    String username = authentication.getName(); // el "sub" del token
    return citaService.getCitasPorUsername(username);
}
* */