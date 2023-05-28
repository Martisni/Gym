package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Propietario;
import com.sanvalero.gym.service.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/gym/propietario")
    public ResponseEntity<List<Propietario>> getPropietario() {
        List<Propietario> propietarios = propietarioService.findAll();
        return ResponseEntity.ok(propietarios);
    }

}
