package com.clinicadental.backend.service;

import com.clinicadental.backend.model.ContactForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

   // @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(ContactForm form) {
        SimpleMailMessage mensaje = new SimpleMailMessage();
        mensaje.setTo("haytameelharhari@gmail.com");//doctor receptor del mensaje
        mensaje.setSubject("Mensaje de: " + form.getNombre() + " - "+form.getAsunto());
        mensaje.setText(
                "Correo: " + form.getCorreo() + "\n" +
                        "Teléfono: " + form.getTelefono() + "\n\n" +
                        "Mensaje:\n" + form.getMensaje()
        );
        mailSender.send(mensaje);
    }
}

