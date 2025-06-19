package com.clinicadental.backend.service;

import com.clinicadental.backend.dto.LoginRequest;
import com.clinicadental.backend.dto.SignupRequest;
import com.clinicadental.backend.model.Usuario;
import com.clinicadental.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    //recibe objeto request {username y password} y lo registra (si ya no lo está)
    public void register(SignupRequest request) {
        if (usuarioRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario {"+request.getUsername()+"} ya está en uso");
        }
        Usuario user = new Usuario();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRol(request.getRol());
        usuarioRepository.save(user);
    }

    public String login(LoginRequest request) {
        Usuario user = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("No hay ninguna cuenta asociada al usuario: "+request.getUsername()));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta.");
        }

        // Generamos un token para ese usuario que se ha logeado
        return jwtService.generateToken(user);

    }
}