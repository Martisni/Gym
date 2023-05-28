package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/gym/entrenadores")
    public ResponseEntity<List<Entrenador>> getEntrenador() {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        return ResponseEntity.ok(entrenadores);
    }

}
