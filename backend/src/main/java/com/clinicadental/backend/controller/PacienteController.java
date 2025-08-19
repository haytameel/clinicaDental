package com.clinicadental.backend.controller;


import com.clinicadental.backend.dto.ApiResponse;
import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.model.Paciente;
import com.clinicadental.backend.service.CitaService;
import com.clinicadental.backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        response=new ApiResponse<>("succes","listado de todos los pacientes",pacientes);
        return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/{id}")//solo puede usarlo el paciente propio de su usuario o el personal
    public ResponseEntity<ApiResponse<Paciente>> obtenerPorId(@PathVariable String id, Authentication authentication) {
        String username = authentication.getName();
        String rol=authentication.getAuthorities().toString();
        // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<Paciente> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") && id.equals(username) || auth.getAuthority().equals("ROLE_ADMIN"))  ) {
            Paciente paciente = pacienteService.getPacienteById(id);
            response=new ApiResponse<>("succes",
                    "Información del paciente obtenida correctamente",
                    paciente);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @PostMapping//lo puede hacer tanto el personal como el paciente
    public ResponseEntity<ApiResponse<Paciente>> crear(@RequestBody Paciente paciente, Authentication authentication) {
        ApiResponse<Paciente> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            Paciente p= pacienteService.savePaciente(paciente);
            response=new ApiResponse<>("succes",
                    "Perfil creado exitosamente",
                    p);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para crear el perfil", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Paciente>> actualizar(@PathVariable String id, @RequestBody Paciente paciente, Authentication authentication) {
        ApiResponse<Paciente> response;
        Paciente res=null;
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            Paciente pacienteExistente = pacienteService.getPacienteById(id);
            if (pacienteExistente != null) {
                pacienteExistente.setId(paciente.getId());
                pacienteExistente.setNombre(paciente.getNombre());
                pacienteExistente.setApellidos(paciente.getApellidos());
                pacienteExistente.setEmail(paciente.getEmail());
                pacienteExistente.setDireccion(paciente.getDireccion());
                pacienteExistente.setGenero(paciente.getGenero());
                pacienteExistente.setNotas(paciente.getNotas());
                pacienteExistente.setFechaNacimiento(paciente.getFechaNacimiento());
                pacienteExistente.setApellidos(paciente.getApellidos());
                pacienteExistente.setTelefono(paciente.getTelefono());
                pacienteExistente.setCodigoPostal(paciente.getCodigoPostal());
                pacienteExistente.setSeguroDental(paciente.getSeguroDental());
                pacienteExistente.setNumSeguro(paciente.getNumSeguro());
                res= pacienteService.savePaciente(pacienteExistente);
            }
            response=new ApiResponse<>("succes",
                    "Perfil creado exitosamente",
                    res);
            return ResponseEntity.ok(response);
        }

        response = new ApiResponse<>("error", "No tienes permisos para actualizar el perfil", res);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);

    }

    @DeleteMapping("/{id}")//que solo la pueda eliminar el personal
    public ResponseEntity<ApiResponse<Boolean>> eliminar(@PathVariable String id, Authentication authentication) {
        String username = authentication.getName();
        String rol=authentication.getAuthorities().toString();
        // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<Boolean> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") && id.equals(username) || auth.getAuthority().equals("ROLE_ADMIN"))  ) {
            pacienteService.deletePaciente(id);
            response=new ApiResponse<>("succes",
                    "Paciente eliminado correctamente",
                   true);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para eliminar al paciente", false);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }



    @GetMapping("/citas")//citas del paciente que hace la peticion
    public ResponseEntity<ApiResponse<List<Cita>>>  getCitasDePacienteAutenticado(Authentication authentication) {
        String username = authentication.getName(); // el "sub" del token

        ApiResponse<List<Cita>> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE"))) {
            List<Cita> citas = citaService.getCitasPorPaciente(username);
            response=new ApiResponse<>("succes","listado de todas las citas",citas);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);

    }

    @PostMapping("/agendarcita")
    public ResponseEntity<ApiResponse<Cita>> agendarCita(@RequestBody Cita nuevaCita,
            Authentication authentication) {

        String username = authentication.getName();
        ApiResponse<Cita> response;

        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE"))) {

            try {
                Cita citaGuardada = citaService.agendarCita(nuevaCita);
                response = new ApiResponse<>("success", "Cita agendada correctamente", citaGuardada);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);

            } catch (Exception e) {
                response = new ApiResponse<>("error", "No se pudo agendar la cita: " + e.getMessage(), null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        }

        response = new ApiResponse<>("error", "No tienes permisos para agendar citas", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}

/*
@GetMapping("/api/citas")
public List<Cita> getCitasDePacienteAutenticado(Authentication authentication) {
    String username = authentication.getName(); // el "sub" del token
    return citaService.getCitasPorUsername(username);
}
* */