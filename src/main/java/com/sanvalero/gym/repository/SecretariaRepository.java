package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Secretaria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SecretariaRepository extends CrudRepository<Secretaria, Long> {

    List<Secretaria> findAll();

}
