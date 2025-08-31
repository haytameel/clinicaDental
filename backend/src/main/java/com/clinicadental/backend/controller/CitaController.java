package com.clinicadental.backend.controller;


import com.clinicadental.backend.dto.ApiResponse;
import com.clinicadental.backend.dto.CitaRequest;
import com.clinicadental.backend.dto.SignupRequest;
import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.model.PeticionCita;
import com.clinicadental.backend.repository.PeticionCitaRepository;
import com.clinicadental.backend.service.CitaService;
import com.clinicadental.backend.service.PeticionCitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private PeticionCitaService peticionCitaService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<Cita>>> listarTodasCitas(Authentication authentication) {

        String username = authentication.getName();
        String rol = authentication.getAuthorities().toString();
        // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<List<Cita>> response;
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            List<Cita> citas = citaService.getTodasCitasPorPaciente(username);
            response = new ApiResponse<>("succes",
                    "Listado de citas obtenido correctamente",
                    citas);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/citas")
    public ResponseEntity<ApiResponse<List<Cita>>> listarTodasCitas() {


        ApiResponse<List<Cita>> response;
        List<Cita> citas = citaService.getTodasCitasPorPaciente("paciente");
        response = new ApiResponse<>("succes",
                "Listado de citas obtenido correctamente",
                citas);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/proximas")
    public ResponseEntity<ApiResponse<List<Cita>>> listarProximasCitas(Authentication authentication) {

        String username = authentication.getName();
        String rol = authentication.getAuthorities().toString();
        // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<List<Cita>> response;
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            List<Cita> citas = citaService.getCitasFuturasPorPaciente(username);
            response = new ApiResponse<>("succes",
                    "Listado de citas obtenido correctamente",
                    citas);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/pasadas")
    public ResponseEntity<ApiResponse<List<Cita>>> listarPasadasCitas(Authentication authentication) {

        String username = authentication.getName();
        String rol = authentication.getAuthorities().toString();
        // System.out.println("-----"+username+"-----"+rol);

        ApiResponse<List<Cita>> response;
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            List<Cita> citas = citaService.getCitasPasadasPorPaciente(username);
            response = new ApiResponse<>("succes",
                    "Listado de citas obtenido correctamente",
                    citas);
            return ResponseEntity.ok(response);
        }
        response = new ApiResponse<>("error", "No tienes permisos para ver esta información", null);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @GetMapping("/prueba")
    public ResponseEntity<ApiResponse<String>> prueba() {

        ApiResponse<String> response = new ApiResponse<>("succes",
                "Listado de citas obtenido correctamente",
                "holaaaaaaaa");
        ;

        return ResponseEntity.ok(response);

    }

    @PostMapping("/solicitar")
    public ResponseEntity<String> solicitar(@RequestBody CitaRequest citaRequest, Authentication authentication) {
        String username = authentication.getName();
        String rol = authentication.getAuthorities().toString();
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN")) && citaRequest.getUsername().equals(username)) {
            try {
                peticionCitaService.save(citaRequest);
                return ResponseEntity.ok("Solicitud de cita presentada correctamente");


            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        } else {
            return ResponseEntity.badRequest().body("No dispones de los permisos para hacer la petición");
        }

    }

    @GetMapping("/peticiones")
    public ResponseEntity<ApiResponse<List<PeticionCita>>> getPeticiones(Authentication authentication) {
        String username = authentication.getName();
        String rol = authentication.getAuthorities().toString();
        ApiResponse<List<PeticionCita>> response;
        if (authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_PACIENTE") || auth.getAuthority().equals("ROLE_ADMIN"))) {
            try {
                List<PeticionCita> res=peticionCitaService.getPeticionesUsuario(username);
                response= new ApiResponse<>("succes", "Listado de peticiones hechas por"+username,res);
                return ResponseEntity.ok(response);

            } catch (Exception e) {
                response = new ApiResponse<>("error", e.getMessage(), null);

            }
        } else {
            response = new ApiResponse<>("error","No dispones de los permisos para hacer la petición", null);
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }
}
