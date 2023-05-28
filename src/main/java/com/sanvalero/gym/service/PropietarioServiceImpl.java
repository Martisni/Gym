package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Propietario;
import com.sanvalero.gym.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PropietarioServiceImpl implements PropietarioService{

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> findAll() {
        return propietarioRepository.findAll();
    }
}
