package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService{

    @Autowired
    private PerfilRepository perfilRepository;

    @Override
    public List<Perfil> findAll() {
        return perfilRepository.findAll();
    }


}
