package com.clinicadental.backend.controller;

import com.clinicadental.backend.repository.PacienteRepository;
import com.clinicadental.backend.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller

public class HomeController {

    @RequestMapping(value = {"/{path:[^\\.]*}", "/{path:^(?!api$).*$}/**"})
    public String redirect() {
        // Renderizar siempre index.html para rutas del frontend
        return "forward:/index.html";
    }
}
