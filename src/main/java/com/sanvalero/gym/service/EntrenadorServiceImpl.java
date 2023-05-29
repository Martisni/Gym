package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServiceImpl implements EntrenadorService {

    @Autowired
    private EntrenadorRepository entrenadorRepository;

    @Override
    public List<Entrenador> findAll() {
        return entrenadorRepository.findAll();
    }

    @Override
    public List<Entrenador> findByDniEntrenador(String dniEntrenador) {
        return entrenadorRepository.findByDniEntrenador(dniEntrenador);
    }

    @Override
    public Entrenador addEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }
}
