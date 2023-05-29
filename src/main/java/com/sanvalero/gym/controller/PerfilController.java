package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/gym/perfiles")
    public ResponseEntity<List<Perfil>> getPerfil() {
        List<Perfil> perfiles = perfilService.findAll();
        return ResponseEntity.ok(perfiles);
    }

}
