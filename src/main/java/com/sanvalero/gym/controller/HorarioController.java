package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Horario;
import com.sanvalero.gym.service.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/gym/horarios")
    public ResponseEntity<List<Horario>> getHorario() {
        List<Horario> horarios = horarioService.findAll();
        return ResponseEntity.ok(horarios);
    }

}
