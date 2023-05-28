package com.sanvalero.gym.repository;

import com.sanvalero.gym.domain.Perfil;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PerfilRepository extends CrudRepository<Perfil, Long> {
    List<Perfil> findAll();
}
