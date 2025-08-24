package com.clinicadental.backend.controller;

import com.clinicadental.backend.dto.LoginRequest;
import com.clinicadental.backend.dto.SignupRequest;
import com.clinicadental.backend.model.Paciente;
import com.clinicadental.backend.repository.PacienteRepository;
import com.clinicadental.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private PacienteRepository pacienteRepository;

    /*Lo dejaremos mas adelante solo para el adin*/
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody SignupRequest request) {
        try {
            authService.register(request);
            return ResponseEntity.ok("Usuario registrado correctamente");
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            String token = authService.login(request);
            return ResponseEntity.ok(Map.of("token", token,"username",request.getUsername() )); //no hace falta el username, se extrae del token
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }


    /*Lo dejaremos mas adelante solo para el adin*/
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {
        try {
            //Registramos usuario
            authService.register(request);
            //creamos paciente
            Paciente paciente = new Paciente(
                    request.getId(),
                    request.getUsername(),
                    request.getNombre(),
                    request.getApellidos(),
                    request.getEmail(),
                    request.getTelefono(),
                    request.getGenero(),
                    request.getFechaNacimiento(),
                    request.getDireccion(),
                    request.getCodigoPostal(),
                    request.getSeguroDental(),
                    request.getNumSeguro(),
                    request.getNotas()
            );
            pacienteRepository.save(paciente);
            return ResponseEntity.ok("Usuario registrado correctamente");
        }
        catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
