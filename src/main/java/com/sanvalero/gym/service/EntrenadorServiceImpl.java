package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.repository.EntrenadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
