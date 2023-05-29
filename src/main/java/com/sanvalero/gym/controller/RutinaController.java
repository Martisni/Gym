package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("/gym/rutinas")
    public ResponseEntity<List<Rutina>> getRutina() {
        List<Rutina> rutinas = rutinaService.findAll();
        return ResponseEntity.ok(rutinas);
    }

}
