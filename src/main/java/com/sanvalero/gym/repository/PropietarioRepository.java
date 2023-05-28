package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Propietario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PropietarioRepository extends CrudRepository<Propietario, Long> {

    List<Propietario> findAll();

}
