package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Horario;
import com.sanvalero.gym.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

}
