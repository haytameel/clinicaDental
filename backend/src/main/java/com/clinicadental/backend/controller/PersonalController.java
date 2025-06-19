package com.clinicadental.backend.controller;


import com.clinicadental.backend.model.Paciente;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/personal")
@CrossOrigin(origins = "*") // importante, para permitir llamadas desde frontend
public class PersonalController {

    @GetMapping
    public List<Paciente> listarTodos() {
        Paciente paciente = new Paciente();
        paciente.setNombre("PEPEEE");
        return List.of(paciente);
    }
}
