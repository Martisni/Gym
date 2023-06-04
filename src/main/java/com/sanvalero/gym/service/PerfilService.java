package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Perfil;
import com.sanvalero.gym.exception.PerfilNotFoundException;

import java.util.List;

public interface PerfilService {
    List<Perfil> findAll();
    Perfil findById(long id) throws PerfilNotFoundException;
    Perfil addPerfil(Perfil perfil) throws PerfilNotFoundException;
    void deletePerfil(long id) throws PerfilNotFoundException;
    Perfil modifyPerfil(long id, Perfil newPerfil) throws PerfilNotFoundException;
}
