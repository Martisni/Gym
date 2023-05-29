package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Entrenador;

import java.util.List;

public interface EntrenadorService {
    List<Entrenador> findAll();
    List<Entrenador> findByDniEntrenador(String dniEntrenador);
    Entrenador addEntrenador(Entrenador entrenador);
}
