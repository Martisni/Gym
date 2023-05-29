package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Rutina;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RutinaRepository extends CrudRepository<Rutina, Long> {

    List<Rutina> findAll();

}
