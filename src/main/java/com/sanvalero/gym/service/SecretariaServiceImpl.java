package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Secretaria;
import com.sanvalero.gym.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecretariaServiceImpl implements SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    @Override
    public List<Secretaria> findAll() {
        return secretariaRepository.findAll();
    }
}
