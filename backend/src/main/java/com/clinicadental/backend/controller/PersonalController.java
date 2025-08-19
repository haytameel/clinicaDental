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


/*

authentication.getName() → devuelve el username (el mismo que en userDetails.getUsername()).

authentication.getAuthorities() → devuelve una colección con los roles/permisos del usuario.

authentication.getCredentials() → en este caso es null porque no pasamos la contraseña aquí.

authentication.getPrincipal() → devuelve el objeto UserDetails completo.

*/