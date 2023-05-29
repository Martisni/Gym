package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.service.EntrenadorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/gym/entrenador")
    public ResponseEntity<List<Entrenador>> getEntrenador(@RequestParam String dniEntrenador) {
        List<Entrenador> entrenador = entrenadorService.findByDniEntrenador(dniEntrenador);
        return ResponseEntity.ok(entrenador);
    }

    @PostMapping("/gym/entrenadores")
    public ResponseEntity<Entrenador> addEntrenador(@Valid @RequestBody Entrenador entrenador) {
        Entrenador entrenados = entrenadorService.addEntrenador(entrenador);
        return ResponseEntity.status(HttpStatus.CREATED).body(entrenados);
    }


}
