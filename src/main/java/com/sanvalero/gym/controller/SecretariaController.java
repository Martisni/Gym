package com.sanvalero.gym.controller;

import com.sanvalero.gym.domain.Secretaria;
import com.sanvalero.gym.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @GetMapping("/gym/secretarias")
    public ResponseEntity<List<Secretaria>> getSecretaria() {
        List<Secretaria> secretarias = secretariaService.findAll();
        return ResponseEntity.ok(secretarias);
    }
}
