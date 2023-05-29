package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Entrenador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntrenadorRepository extends CrudRepository<Entrenador, Long> {

    List<Entrenador> findAll();
    List<Entrenador> findByDniEntrenador(String dniEntrenador);
}
