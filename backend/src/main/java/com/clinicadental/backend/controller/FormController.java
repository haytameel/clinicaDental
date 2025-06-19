package com.clinicadental.backend.controller;

import com.clinicadental.backend.model.ContactForm;
import com.clinicadental.backend.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173") // importante, para permitir llamadas desde frontend
@RestController
@RequestMapping("/api/contacto")
public class FormController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> enviar(@RequestBody ContactForm form) {
        emailService.enviarCorreo(form);
        return ResponseEntity.ok("Correo enviado correctamente");
    }

    @GetMapping
    public ResponseEntity<String> list(){
        return ResponseEntity.ok("Lista de contactos");
        //        response.sendRedirect("https://otra-pagina.com");
    }
}
