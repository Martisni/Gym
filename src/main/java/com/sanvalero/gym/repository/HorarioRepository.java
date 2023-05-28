package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Horario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HorarioRepository extends CrudRepository<Horario, Long> {

    List<Horario> findAll();

}
