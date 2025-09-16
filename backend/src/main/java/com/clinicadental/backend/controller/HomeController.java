package com.clinicadental.backend.controller;

import com.clinicadental.backend.repository.PacienteRepository;
import com.clinicadental.backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/")
    public String home() {
        return "Backend funcionando 🚀";
    }


    @GetMapping("/prueba")
    public String prueba() {
        return pacienteService.getAllPacientes().toString();
    }
}
