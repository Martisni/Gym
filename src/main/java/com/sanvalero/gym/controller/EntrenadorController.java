package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.service.EntrenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EntrenadorController {

    @Autowired
    private EntrenadorService entrenadorService;

    @GetMapping("/gym/entrenadores")
    public ResponseEntity<List<Entrenador>> getEntrenadores() {
        List<Entrenador> entrenadores = entrenadorService.findAll();
        return ResponseEntity.ok(entrenadores);
    }

    @GetMapping("/gym/entrenador/{dniEntrenador}")
    public ResponseEntity<List<Entrenador>> getEntrenador(@RequestParam String dniEntrenador) {
        List<Entrenador> entrenador = entrenadorService.findByDniEntrenador(dniEntrenador);
        return ResponseEntity.ok(entrenador);
    }


}
