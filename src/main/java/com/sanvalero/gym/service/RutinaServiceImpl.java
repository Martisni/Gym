package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Rutina;
import com.sanvalero.gym.repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaServiceImpl implements RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    @Override
    public List<Rutina> findAll() {
        return rutinaRepository.findAll();
    }
}
