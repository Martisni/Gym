package com.sanvalero.gym.service;

import com.sanvalero.gym.domain.Propietario;
import com.sanvalero.gym.exception.PropietarioNotFoundException;

import java.util.List;

public interface PropietarioService {
    List<Propietario> findAll();
    Propietario findById(long id) throws PropietarioNotFoundException;
    Propietario addPropietario(Propietario propietario) throws PropietarioNotFoundException;
    void deletePropietario(long id) throws PropietarioNotFoundException;
    Propietario modifyPropietario(long id, Propietario newPropietario) throws PropietarioNotFoundException;
}
