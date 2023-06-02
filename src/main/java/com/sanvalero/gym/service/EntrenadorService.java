package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Entrenador;
import com.sanvalero.gym.exception.EntrenadorNotFoundException;

import java.util.List;

public interface EntrenadorService {
    List<Entrenador> findAll();
    List<Entrenador> findByDniEntrenador(String dniEntrenador);
    List<Entrenador> findByEspecialidad(boolean especialidad);
    Entrenador findById(long id) throws EntrenadorNotFoundException;
    Entrenador addEntrenador(Entrenador entrenador) throws EntrenadorNotFoundException;
    void deleteEntrenador(long id) throws EntrenadorNotFoundException;
    Entrenador modifyEntrenador(long id, Entrenador newEntrenador) throws EntrenadorNotFoundException;
}
