package com.clinicadental.backend.repository;

import com.clinicadental.backend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByUsername(String username);
    List<Usuario> findAll();


    //REALMENTE ESTOS METODOS YA VIENEN IMPLEMENTADOS POR DEFECTO...
}

