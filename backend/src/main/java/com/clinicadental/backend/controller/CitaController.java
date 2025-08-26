package com.clinicadental.backend.controller;


import com.clinicadental.backend.dto.ApiResponse;
import com.clinicadental.backend.model.Cita;
import com.clinicadental.backend.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;


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


}
